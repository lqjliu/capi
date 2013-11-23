package com.carucrm.biz.consume;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.caru.exception.DataFormatInvalidException;
import com.caru.util.StringUtil;
import com.carucrm.biz.carowner.ConsumeListBean;
import com.carucrm.util.ConsumeIDGenerator;
import com.carucrm.vo.ConsumeVO;
import com.carucrm.vo.ConsumeitemVO;
import com.carucrm.vo.CustomerVO;
import com.common.db.DBAgentOO;
import com.common.web.RequestContext;
import com.common.web.Token;

public class ConsumeMgrImpl {
	private static ConsumeMgrImpl instance = new ConsumeMgrImpl();
	private static final int CUSTOMER_IS_NULL = 1;
	private static final int INDATE_IS_NULL = 2;
	private static final int OUTDATE_IS_NULL = 3;
	private static final int PAIDDATE_IS_NULL = 4;
	private static final int ACTUALMONEY_IS_NULL = 5;
	private static final int SERVICEITEMS_IS_NULL = 6;
	private static final int CUSTOMERID_IS_INVALID = 7;

	public static ConsumeMgrImpl getInstance() {
		return instance;
	}

	private ConsumeMgrImpl() {
	}

	private boolean consumeValidateNull(ConsumeBean consumeBean,
			ConsumeResultBean consumeResultBean) {
		boolean result = true;
		if (consumeBean.getCustomerid() == 0) {
			consumeResultBean.setErrorcode(CUSTOMER_IS_NULL);
			consumeResultBean.setCmdstatus(false);
			return false;
		}
		if (consumeBean.getIndate() == null) {
			consumeResultBean.setErrorcode(INDATE_IS_NULL);
			consumeResultBean.setCmdstatus(false);
			return false;
		}
		if (consumeBean.getOutdate() == null) {
			consumeResultBean.setErrorcode(OUTDATE_IS_NULL);
			consumeResultBean.setCmdstatus(false);
			return false;
		}
		if (consumeBean.getPaiddate() == null) {
			consumeResultBean.setErrorcode(PAIDDATE_IS_NULL);
			consumeResultBean.setCmdstatus(false);
			return false;
		}
		if (consumeBean.getActualmoney() == 0) {
			consumeResultBean.setErrorcode(ACTUALMONEY_IS_NULL);
			consumeResultBean.setCmdstatus(false);
			return false;
		}
		if (consumeBean.getSupport2handexchange() == 0
				&& consumeBean.getSupportcrossplaceregister() == 0
				&& consumeBean.getSupportdecorate() == 0
				&& consumeBean.getSupportinsuranceconsult() == 0
				&& consumeBean.getSupportmaintain() == 0
				&& consumeBean.getSupportnewcarregister() == 0
				&& consumeBean.getSupportrepair() == 0
				&& consumeBean.getSupportwashing() == 0) {
			consumeResultBean.setErrorcode(SERVICEITEMS_IS_NULL);
			consumeResultBean.setCmdstatus(false);
			return false;
		}
		return result;
	}

	public ConsumeResultBean addConsume(ConsumeBean consumeBean)
			throws Exception {
		ConsumeResultBean result = new ConsumeResultBean();
		if (!consumeValidateNull(consumeBean, result)) {
			return result;
		}
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			Date now = new Date();
			dbAgentOO.beginTransaction();
			int customerid = consumeBean.getCustomerid();
			CustomerVO customerVO = new CustomerVO();
			customerVO.setId(customerid);
			customerVO.setWhereId(true);
			customerVO.setCorporationid(token.getCorporationid());
			customerVO.setWhereCorporationid(true);
			customerVO = (CustomerVO) dbAgentOO.select(customerVO);
			if (customerVO == null) {
				result.setErrorcode(CUSTOMERID_IS_INVALID);
				result.setCmdstatus(false);
				return result;
			}
			ConsumeVO consumeVO = getConsumeVO(token, consumeBean, now);
			consumeVO.setCreatedtime(now);
			int consumeId = ConsumeIDGenerator.getInstance().getId();
			consumeVO.setId(consumeId);
			dbAgentOO.insert(consumeVO);
			consumeBean.getConsumeitems();
			for (int i = 0; i < consumeBean.getConsumeitems().size(); i++) {
				ConsumeitemVO consumeitemVO = getConsumeitemVO(consumeBean
						.getConsumeitems().get(i), now);
				consumeitemVO.setConsumeid(consumeId);
				consumeitemVO.setNo(i + 1);
				dbAgentOO.insert(consumeitemVO);
			}
			double cumulateMoney = customerVO.getCumulatemoney();
			cumulateMoney += consumeBean.getActualmoney();
			consumeVO = new ConsumeVO();
			customerVO.setId(customerid);
			customerVO.setWhereId(true);
			customerVO.setCorporationid(token.getCorporationid());
			customerVO.setWhereCorporationid(true);
			customerVO.setCumulatemoney(cumulateMoney);
			customerVO.setLatestconsumedate(consumeBean.getPaiddate());
			customerVO.setLatestconsumemoney(consumeBean.getActualmoney());
			customerVO.setLatestconsumeid(consumeId);
			dbAgentOO.update(customerVO);
			dbAgentOO.commitTransaction();
			result.setConsumeid(consumeId);
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		} finally {
			dbAgentOO.releaseTransaction();
		}
		return result;
	}

	public ConsumeResultBean editConsume(ConsumeBean consumeBean)
			throws Exception {
		ConsumeResultBean result = new ConsumeResultBean();
		if (!consumeValidateNull(consumeBean, result)) {
			return result;
		}
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			Date now = new Date();
			dbAgentOO.beginTransaction();
			CustomerVO originalCustomerVO = new CustomerVO();
			originalCustomerVO.setId(consumeBean.getCustomerid());
			originalCustomerVO.setWhereId(true);
			originalCustomerVO.setCorporationid(token.getCorporationid());
			originalCustomerVO.setWhereCorporationid(true);
			originalCustomerVO = (CustomerVO) dbAgentOO
					.select(originalCustomerVO);
			if (originalCustomerVO == null) {
				result.setErrorcode(CUSTOMERID_IS_INVALID);
				result.setCmdstatus(false);
				return result;
			}
			ConsumeVO consumeVO = getConsumeVO(token, consumeBean, now);
			consumeVO.setId(consumeBean.getConsumeid());
			consumeVO.setWhereId(true);
			consumeVO.setCorporationid(token.getCorporationid());
			consumeVO.setWhereCorporationid(true);
			consumeVO.setCustomerid(consumeBean.getCustomerid());
			consumeVO.setWhereCustomerid(true);
			ConsumeVO orginalConsumeVO = new ConsumeVO();
			orginalConsumeVO.setId(consumeBean.getConsumeid());
			orginalConsumeVO.setWhereId(true);
			orginalConsumeVO.setCorporationid(token.getCorporationid());
			orginalConsumeVO.setWhereCorporationid(true);
			orginalConsumeVO.setCustomerid(consumeBean.getCustomerid());
			orginalConsumeVO.setWhereCustomerid(true);
			orginalConsumeVO = (ConsumeVO)dbAgentOO.select(orginalConsumeVO);
			dbAgentOO.update(consumeVO);
			ConsumeitemVO deleteConsumeitemVO = new ConsumeitemVO();
			deleteConsumeitemVO.setConsumeid(consumeBean.getConsumeid());
			deleteConsumeitemVO.setWhereConsumeid(true);
			dbAgentOO.delete(deleteConsumeitemVO);
			consumeBean.getConsumeitems();
			for (int i = 0; i < consumeBean.getConsumeitems().size(); i++) {
				ConsumeitemVO consumeitemVO = getConsumeitemVO(consumeBean
						.getConsumeitems().get(i), now);
				consumeitemVO.setConsumeid(consumeBean.getConsumeid());
				consumeitemVO.setNo(i + 1);
				dbAgentOO.insert(consumeitemVO);
			}

			int latestConsumeid = originalCustomerVO.getLatestconsumeid();
			if (latestConsumeid == consumeBean.getConsumeid()) {
				double cumulateMoney = originalCustomerVO.getCumulatemoney();
				cumulateMoney -= originalCustomerVO.getLatestconsumemoney();
				cumulateMoney += consumeBean.getActualmoney();
				CustomerVO customerVO = new CustomerVO();
				customerVO.setId(originalCustomerVO.getId());
				customerVO.setWhereId(true);
				customerVO.setCorporationid(token.getCorporationid());
				customerVO.setWhereCorporationid(true);
				customerVO.setCumulatemoney(cumulateMoney);
				customerVO.setLatestconsumedate(consumeBean.getPaiddate());
				customerVO.setLatestconsumemoney(consumeBean.getActualmoney());
				dbAgentOO.update(customerVO);
			}else{
				double cumulateMoney = originalCustomerVO.getCumulatemoney();
				cumulateMoney -= orginalConsumeVO.getActualmoney();
				cumulateMoney += consumeBean.getActualmoney();
				CustomerVO customerVO = new CustomerVO();
				customerVO.setId(originalCustomerVO.getId());
				customerVO.setWhereId(true);
				customerVO.setCorporationid(token.getCorporationid());
				customerVO.setWhereCorporationid(true);
				customerVO.setCumulatemoney(cumulateMoney);
				dbAgentOO.update(customerVO);
			}
			dbAgentOO.commitTransaction();
			result.setConsumeid(latestConsumeid);
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		} finally {
			dbAgentOO.releaseTransaction();
		}
		return result;
	}

	public ConsumeBean getConsume(ConsumeIDBean consumeIDBean) throws Exception {
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		ConsumeBean result = null;
		try {
			dbAgentOO.beginTransaction();
			ConsumeVO consumeVO = getConsumeVO(token, consumeIDBean, dbAgentOO);
			CustomerVO customerVO = getCustomerVO(token, consumeIDBean,
					dbAgentOO);

			result = getConsumeBean(consumeVO, customerVO);
			String sql = "SELECT NAME,money, remark,unit,price,amount,TYPE FROM consumeitem where consumeid = "
					+ consumeIDBean.getConsumeid() + " order by no";
			List list = dbAgentOO.selectData(sql,
					"com.carucrm.biz.consume.ConsumeitemBean");
			result.setConsumeitems(list);
			dbAgentOO.commitTransaction();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		} finally {
			dbAgentOO.releaseTransaction();
		}
		return result;
	}

	public void deleteConsume(ConsumeIDBean consumeIDBean) throws Exception {
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			ConsumeitemVO deleteConsumeitemVO = new ConsumeitemVO();
			deleteConsumeitemVO.setConsumeid(consumeIDBean.getConsumeid());
			deleteConsumeitemVO.setWhereConsumeid(true);
			dbAgentOO.delete(deleteConsumeitemVO);
			ConsumeVO result = new ConsumeVO();
			result.setCorporationid(token.getCorporationid());
			result.setWhereCorporationid(true);
			result.setCustomerid(consumeIDBean.getCustomerid());
			result.setWhereCustomerid(true);
			result.setId(consumeIDBean.getConsumeid());
			result.setWhereId(true);
			dbAgentOO.delete(result);
			dbAgentOO.commitTransaction();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		} finally {
			dbAgentOO.releaseTransaction();
		}
	}

	private ConsumeBean getConsumeBean(ConsumeVO consumeVO,
			CustomerVO customerVO) throws Exception {
		ConsumeBean result = new ConsumeBean();
		result.setConsumeid(consumeVO.getId());
		result.setCustomerid(consumeVO.getCustomerid());
		result.setOdometer(consumeVO.getOdometer());
		result.setSolution(consumeVO.getSolution());
		result.setIndate(consumeVO.getIndate());
		result.setRemark(consumeVO.getRemark());
		result.setPhoenoment(consumeVO.getPhoenoment());
		revertServiceItems(result, consumeVO);
		result.setMaterialfee(consumeVO.getMaterialfee());
		result.setMaterialgapfee(consumeVO.getMaterialgapfee());
		result.setOutsourcingfee(consumeVO.getOutsourcingfee());
		result.setManagementfee(consumeVO.getManagementfee());
		result.setDragfee(consumeVO.getDragfee());
		result.setTax(consumeVO.getTax());
		result.setOtherfee(consumeVO.getOtherfee());
		result.setOutdate(consumeVO.getOutdate());
		result.setCalculatedmoney(consumeVO.getCalculatedmoney());
		result.setActualmoney(consumeVO.getActualmoney());
		result.setDiscountmoney(consumeVO.getDiscountmoney());
		result.setPaiddate(consumeVO.getPaiddate());
		result.setInternalremark(consumeVO.getInternalremark());
		result.setCustomermobile(customerVO.getMobile());
		result.setCustomername(customerVO.getName());
		result.setCustomerplatenumber(customerVO.getPlatenumber());
		return result;
	}

	private void revertServiceItems(ConsumeBean result, ConsumeVO consumeVO) {

		String serviceItems = consumeVO.getServiceitems();
		String[] serviceItemss = StringUtil.splitString(serviceItems, ",");
		int serviceOptions[] = new int[8];
		for (int i = 0; i < 8; i++) {
			String service = serviceItemss[i];
			serviceOptions[i] = Integer.parseInt(service.substring(
					service.indexOf("=") + 1).trim());
		}
		result.setSupportrepair(serviceOptions[0]);
		result.setSupportmaintain(serviceOptions[1]);
		result.setSupportwashing(serviceOptions[2]);
		result.setSupportdecorate(serviceOptions[3]);
		result.setSupportinsuranceconsult(serviceOptions[4]);
		result.setSupportnewcarregister(serviceOptions[5]);
		result.setSupportcrossplaceregister(serviceOptions[6]);
		result.setSupport2handexchange(serviceOptions[7]);

	}

	private ConsumeVO getConsumeVO(Token token, ConsumeIDBean consumeIDBean,
			DBAgentOO dbAgentOO) throws Exception {
		ConsumeVO result = new ConsumeVO();
		result.setCorporationid(token.getCorporationid());
		result.setWhereCorporationid(true);
		result.setCustomerid(consumeIDBean.getCustomerid());
		result.setWhereCustomerid(true);
		result.setId(consumeIDBean.getConsumeid());
		result.setWhereId(true);
		result = (ConsumeVO) dbAgentOO.select(result);
		return result;
	}

	private CustomerVO getCustomerVO(Token token, ConsumeIDBean consumeIDBean,
			DBAgentOO dbAgentOO) throws Exception {
		CustomerVO result = new CustomerVO();
		result.setCorporationid(token.getCorporationid());
		result.setWhereCorporationid(true);
		result.setId(consumeIDBean.getCustomerid());
		result.setWhereId(true);
		result = (CustomerVO) dbAgentOO.select(result);
		return result;
	}

	private ConsumeitemVO getConsumeitemVO(ConsumeitemBean consumeitemBean,
			Date now) throws Exception {
		ConsumeitemVO result = new ConsumeitemVO();
		result.setName(consumeitemBean.getName());
		result.setMoney(consumeitemBean.getMoney());
		result.setRemark(consumeitemBean.getRemark());
		result.setUnit(consumeitemBean.getUnit());
		result.setPrice(consumeitemBean.getPrice());
		result.setAmount(consumeitemBean.getAmount());
		result.setType(consumeitemBean.getType());
		result.setLastmodifiedtime(now);
		result.setCreatedtime(now);
		return result;
	}

	private ConsumeVO getConsumeVO(Token token, ConsumeBean consumeBean,
			Date now) throws Exception {
		ConsumeVO result = new ConsumeVO();
		result.setCorporationid(token.getCorporationid());
		result.setCustomerid(consumeBean.getCustomerid());
		result.setOdometer(consumeBean.getOdometer());
		result.setIndate(consumeBean.getIndate());
		result.setSolution(consumeBean.getSolution());
		result.setRemark(consumeBean.getRemark());
		result.setPhoenoment(consumeBean.getPhoenoment());
		assembleServiceItems(consumeBean, result);
		result.setMaterialfee(consumeBean.getMaterialfee());
		result.setMaterialgapfee(consumeBean.getMaterialgapfee());
		result.setOutsourcingfee(consumeBean.getOutsourcingfee());
		result.setManagementfee(consumeBean.getManagementfee());
		result.setDragfee(consumeBean.getDragfee());
		result.setTax(consumeBean.getTax());
		result.setOtherfee(consumeBean.getOtherfee());
		result.setOutdate(consumeBean.getOutdate());
		result.setCalculatedmoney(consumeBean.getCalculatedmoney());
		result.setActualmoney(consumeBean.getActualmoney());
		result.setDiscountmoney(consumeBean.getDiscountmoney());
		result.setPaiddate(consumeBean.getPaiddate());
		result.setInternalremark(consumeBean.getInternalremark());
		result.setActive(1);
		result.setLastmodifiedtime(now);
		return result;
	}

	private static String SERVICE_TYPE[] = { "repair", "maintain", "washing",
			"decorate", "insuranceconsult", "newcarregister",
			"crossplaceregister", "2handexchange" };

	private void assembleServiceItems(ConsumeBean consumeBean,
			ConsumeVO consumeVO) {
		int serviceOptions[] = new int[8];
		serviceOptions[0] = consumeBean.getSupportrepair();
		serviceOptions[1] = consumeBean.getSupportmaintain();
		serviceOptions[2] = consumeBean.getSupportwashing();
		serviceOptions[3] = consumeBean.getSupportdecorate();
		serviceOptions[4] = consumeBean.getSupportinsuranceconsult();
		serviceOptions[5] = consumeBean.getSupportnewcarregister();
		serviceOptions[6] = consumeBean.getSupportcrossplaceregister();
		serviceOptions[7] = consumeBean.getSupport2handexchange();
		String serviceItems = "";
		for (int i = 0; i < 8; i++) {
			if (i != 0) {
				serviceItems += ",";
			}
			serviceItems += (SERVICE_TYPE[i] + "=" + serviceOptions[i]);
		}
		consumeVO.setServiceitems(serviceItems);
	}

	private final int ROW_COUNT_PER_PAGE = 20;

	public ConsumeListResultBean listConsume(
			ConsumeListConditionBean consumeListConditionBean) throws Exception {
		ConsumeListResultBean result = new ConsumeListResultBean();
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			String condition = getListSqlCondition(consumeListConditionBean,
					token);
			String sqlRecordcount = "SELECT count(actualmoney) " + condition;
			String sCount = dbAgentOO.selectSingleValue(sqlRecordcount);
			int count = Integer.parseInt(sCount);
			int pageSize = 0;
			if (count % ROW_COUNT_PER_PAGE == 0) {
				pageSize = count / ROW_COUNT_PER_PAGE;
			} else {
				pageSize = count / ROW_COUNT_PER_PAGE + 1;
			}
			result.setPagesize(pageSize);
			int pos = (consumeListConditionBean.getCurrentpageno() - 1)
					* ROW_COUNT_PER_PAGE;
			String sql = " SELECT b.paiddate, a.id customerid, a.platenumber,a.name,a.mobile, b.serviceitems, b.actualmoney, b.id consumeid "
					+ condition;

			List listData = dbAgentOO.selectData(sql,
					"com.carucrm.biz.consume.CustomerConsume", pos,
					ROW_COUNT_PER_PAGE);
			Date itemDate = null;
			double summaryMoney = 0;
			List summaryList = null;
			int customerId = 0;
			List customerConsumeList = new ArrayList();
			CustomerConsumeResultBean customerConsumeResultBean = null;
			for (int i = 0; i < listData.size(); i++) {
				CustomerConsume customerConsume = (CustomerConsume) listData
						.get(i);
				revertServiceItems(customerConsume);
				if (consumeListConditionBean.getListway() == 0) {
					if (customerConsume.getPaiddate().equals(itemDate)) {
						summaryMoney += customerConsume.getActualmoney();
						customerConsumeResultBean.setSummarymoney(summaryMoney);
					} else {
						itemDate = customerConsume.getPaiddate();
						summaryMoney = customerConsume.getActualmoney();
						summaryList = new ArrayList();
						customerConsumeResultBean = new CustomerConsumeResultBean();
						customerConsumeResultBean
								.setCustomerconsume(summaryList);
						customerConsumeResultBean.setDate(itemDate);
						customerConsumeResultBean.setSummarymoney(summaryMoney);
						customerConsumeList.add(customerConsumeResultBean);
					}
				} else {
					if (customerConsume.getCustomerid() == customerId) {
						summaryMoney += customerConsume.getActualmoney();
						customerConsumeResultBean.setSummarymoney(summaryMoney);
					} else {
						customerId = customerConsume.getCustomerid();
						summaryMoney = customerConsume.getActualmoney();
						summaryList = new ArrayList();
						customerConsumeResultBean = new CustomerConsumeResultBean();
						customerConsumeResultBean
								.setCustomerconsume(summaryList);
						customerConsumeResultBean.setCustomerid(customerId);
						customerConsumeResultBean.setSummarymoney(summaryMoney);
						customerConsumeResultBean
								.setCustomermobile(customerConsume.getMobile());
						customerConsumeResultBean
								.setCustomername(customerConsume.getName());
						customerConsumeList.add(customerConsumeResultBean);
					}
				}
				summaryList.add(customerConsume);
			}
			if (customerConsumeList.size() > 0) {
				CustomerConsumeResultBean customerConsumeResultBean1 = (CustomerConsumeResultBean) customerConsumeList
						.get(0);
				CustomerConsumeResultBean customerConsumeResultBean2 = (CustomerConsumeResultBean) customerConsumeList
						.get(customerConsumeList.size() - 1);
				if (consumeListConditionBean.getCurrentpageno() != 1) {
					correctSummaryMoneyForTheRecordInPaginationBorder(
							consumeListConditionBean, token, dbAgentOO,
							customerConsumeResultBean1);
				}
				correctSummaryMoneyForTheRecordInPaginationBorder(
						consumeListConditionBean, token, dbAgentOO,
						customerConsumeResultBean2);

			}
			dbAgentOO.commitTransaction();
			result.setListconsume(customerConsumeList);
			result
					.setCurrentpageno(consumeListConditionBean
							.getCurrentpageno());
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		} finally {
			dbAgentOO.releaseTransaction();
		}
		return result;
	}

	private void revertServiceItems(CustomerConsume result) {

		String serviceItems = result.getServiceitems();
		String[] serviceItemss = StringUtil.splitString(serviceItems, ",");
		int serviceOptions[] = new int[8];
		for (int i = 0; i < 8; i++) {
			String service = serviceItemss[i];
			serviceOptions[i] = Integer.parseInt(service.substring(
					service.indexOf("=") + 1).trim());
		}
		result.setSupportrepair(serviceOptions[0]);
		result.setSupportmaintain(serviceOptions[1]);
		result.setSupportwashing(serviceOptions[2]);
		result.setSupportdecorate(serviceOptions[3]);
		result.setSupportinsuranceconsult(serviceOptions[4]);
		result.setSupportnewcarregister(serviceOptions[5]);
		result.setSupportcrossplaceregister(serviceOptions[6]);
		result.setSupport2handexchange(serviceOptions[7]);
		result.setServiceitems(null);

	}

	private void correctSummaryMoneyForTheRecordInPaginationBorder(
			ConsumeListConditionBean consumeListConditionBean, Token token,
			DBAgentOO dbAgentOO,
			CustomerConsumeResultBean customerConsumeResultBean1)
			throws DataFormatInvalidException, Exception {
		if (consumeListConditionBean.getListway() == 0) {
			Date date = customerConsumeResultBean1.getDate();
			String sDate = ConsumeMgrImpl.formatDate(date);
			String sql1 = "SELECT SUM(actualmoney) FROM consume WHERE corporationid = "
					+ token.getCorporationid()
					+ " AND paiddate = '"
					+ sDate
					+ "'";
			String sSummaryMoney = dbAgentOO.selectSingleValue(sql1);
			double summaryMoney1 = Double.parseDouble(sSummaryMoney);
			customerConsumeResultBean1.setSummarymoney(summaryMoney1);
		} else {
			int customerid = customerConsumeResultBean1.getCustomerid();
			String sql1 = "SELECT SUM(actualmoney) FROM consume WHERE corporationid = "
					+ token.getCorporationid()
					+ " AND customerid = "
					+ customerid;
			String sSummaryMoney = dbAgentOO.selectSingleValue(sql1);
			double summaryMoney1 = Double.parseDouble(sSummaryMoney);
			customerConsumeResultBean1.setSummarymoney(summaryMoney1);
		}
	}

	private String getListSqlCondition(
			ConsumeListConditionBean consumeListConditionBean, Token token)
			throws DataFormatInvalidException {
		String sql = " FROM customer a, consume b WHERE a.corporationid = b.corporationid "
				+ " AND a.id = b.customerid"
				+ " AND a.corporationid = "
				+ token.getCorporationid();
		if (consumeListConditionBean.getCustomerid() != 0) {
			sql += " AND a.id = " + consumeListConditionBean.getCustomerid()
					+ " ";
		}
		if (consumeListConditionBean.getStartdate() != null
				&& consumeListConditionBean.getEnddate() != null) {
			sql += " AND b.paiddate BETWEEN   '"
					+ ConsumeMgrImpl.formatDate(consumeListConditionBean
							.getStartdate())
					+ "' AND '"
					+ ConsumeMgrImpl.formatDate(consumeListConditionBean
							.getEnddate()) + " '";
		}
		if (consumeListConditionBean.getStartdate() != null
				&& consumeListConditionBean.getEnddate() == null) {
			sql += " AND b.paiddate BETWEEN   '"
					+ ConsumeMgrImpl.formatDate(consumeListConditionBean
							.getStartdate()) + "' AND '2020-01-01 '";
		}
		if (consumeListConditionBean.getStartdate() == null
				&& consumeListConditionBean.getEnddate() != null) {
			sql += " AND b.paiddate BETWEEN   '2000-01-01"
					+ "' AND '"
					+ ConsumeMgrImpl.formatDate(consumeListConditionBean
							.getEnddate()) + "' ";
		}
		if (consumeListConditionBean.getStartmoney() > 0) {
			sql += " AND b.actualmoney > "
					+ consumeListConditionBean.getStartmoney() + " ";
		}
		if (consumeListConditionBean.getEndmoney() > 0) {
			sql += " AND b.actualmoney < "
					+ consumeListConditionBean.getEndmoney() + " ";
		}
		String serviceitemcondition = assembleListServiceItems(consumeListConditionBean);
		if (!"".equals(serviceitemcondition)) {
			sql += "AND b.serviceitems LIKE '" + serviceitemcondition + "'";
		}
		if (consumeListConditionBean.getListway() == 0) {
			sql += " ORDER BY paiddate DESC ";
		} else {
			sql += " ORDER BY customerid ";
		}
		return sql;
	}

	private String assembleListServiceItems(
			ConsumeListConditionBean consumeListConditionBean) {
		int serviceOptions[] = new int[8];
		serviceOptions[0] = consumeListConditionBean.getSupportrepair();
		serviceOptions[1] = consumeListConditionBean.getSupportmaintain();
		serviceOptions[2] = consumeListConditionBean.getSupportwashing();
		serviceOptions[3] = consumeListConditionBean.getSupportdecorate();
		serviceOptions[4] = consumeListConditionBean
				.getSupportinsuranceconsult();
		serviceOptions[5] = consumeListConditionBean.getSupportnewcarregister();
		serviceOptions[6] = consumeListConditionBean
				.getSupportcrossplaceregister();
		serviceOptions[7] = consumeListConditionBean.getSupport2handexchange();
		String result = "";
		for (int i = 0; i < 8; i++) {
			if (serviceOptions[i] == 0) {
				if (i != 0 && serviceOptions[i - 1] == 1) {
					result += "%";
				}
				result += (SERVICE_TYPE[i] + "=0");
				if (i != 7) {
					result += ",";
				}
			}
		}
		if (!"".equals(result) && serviceOptions[7] == 1) {
			result += "%";
		}
		return result;
	}

	private static String formatDate(Date date)
			throws DataFormatInvalidException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = null;
		try {
			result = sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
