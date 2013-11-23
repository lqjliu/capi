package com.carucrm.biz.carowner;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.caru.exception.DataFormatInvalidException;
import com.caru.util.StringUtil;
import com.carucrm.vo.CarVO;
import com.carucrm.vo.ConsumeVO;
import com.carucrm.vo.ContactVO;
import com.carucrm.vo.CorporationVO;
import com.carucrm.vo.CustomerVO;
import com.common.db.DBAgentOO;
import com.common.exception.CapiException;
import com.common.exception.ExceptionKeys;
import com.common.web.RequestContext;
import com.common.web.Token;

public class ConsumeMgrImpl {
	private static ConsumeMgrImpl instance = new ConsumeMgrImpl();

	public static ConsumeMgrImpl getInstance() {
		return instance;
	}

	private ConsumeMgrImpl() {
	}

	private final int ROW_COUNT_PER_PAGE = 20;

	private ContactVO getContactVO(int contactID, DBAgentOO dbAgentOO)
			throws SQLException, Exception {
		ContactVO contactVO = new ContactVO();
		contactVO.setId(contactID);
		contactVO.setWhereId(true);
		contactVO = (ContactVO) dbAgentOO.select(contactVO);
		return contactVO;
	}

	private CarVO getCarVO(int accountID, DBAgentOO dbAgentOO)
			throws SQLException, Exception {
		CarVO carVO = new CarVO();
		carVO.setAccountid(accountID);
		carVO.setWhereAccountid(true);
		carVO = (CarVO) dbAgentOO.select(carVO);
		return carVO;
	}

	public ConsumeListResultBean listCarOwnerConsume(
			ConsumeListConditionBean consumeListConditionBean) throws Exception {
		ConsumeListResultBean result = new ConsumeListResultBean();
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			ContactVO contactVO = getContactVO(token.getContactid(), dbAgentOO);
			CarVO carVO = getCarVO(token.getAccountid(), dbAgentOO);
			String mobile = contactVO.getMobile();
			String platenumber = carVO.getPlatenumber();

			String condition = getListSqlCondition(consumeListConditionBean,
					mobile, platenumber);
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
			String sql = " SELECT c.paiddate DATE, a.id corporationid, a.name corporationname, c.serviceitems,c.actualmoney  money,c.serviceitems, b.id customerid, c.id consumeid  "
					+ condition;

			if (consumeListConditionBean.getOrderby() != null) {
				sql += (" order by " + consumeListConditionBean.getOrderby());
				if (consumeListConditionBean.getOrderway() == 1) {
					sql += " desc ";
				}
			}
			List listData = dbAgentOO.selectData(sql,
					"com.carucrm.biz.carowner.ConsumeListBean", pos,
					ROW_COUNT_PER_PAGE);

			dbAgentOO.commitTransaction();
			for (int i = 0; i < listData.size(); i++) {
				ConsumeListBean consumeListBean = (ConsumeListBean) listData
						.get(i);
				revertServiceItems(consumeListBean);
			}
			result.setCarownerconsume(listData);
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

	private void revertServiceItems(ConsumeListBean result) {

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

	private String getListSqlCondition(
			ConsumeListConditionBean consumeListConditionBean, String mobile,
			String platenumber) throws DataFormatInvalidException {
		String sql = " FROM corporation a, customer b, consume c WHERE a.id =b.corporationid "
				+ " AND b.corporationid = c.corporationid AND b.id = c.customerid "
				+ " AND b.mobile = '"
				+ mobile
				+ "' AND b.platenumber = '"
				+ platenumber + "' ";
		if (consumeListConditionBean.getCorporationid() != 0) {
			sql += " AND a.id = " + consumeListConditionBean.getCorporationid()
					+ "  ";
		}
		if (consumeListConditionBean.getStartdate() != null
				&& consumeListConditionBean.getEnddate() != null) {
			sql += " AND c.paiddate BETWEEN   '"
					+ ConsumeMgrImpl.formatDate(consumeListConditionBean
							.getStartdate())
					+ "' AND '"
					+ ConsumeMgrImpl.formatDate(consumeListConditionBean
							.getEnddate()) + " '";
		}
		if (consumeListConditionBean.getStartdate() != null
				&& consumeListConditionBean.getEnddate() == null) {
			sql += " AND c.paiddate BETWEEN   '"
					+ ConsumeMgrImpl.formatDate(consumeListConditionBean
							.getStartdate()) + "' AND '2020-01-01 '";
		}
		if (consumeListConditionBean.getStartdate() == null
				&& consumeListConditionBean.getEnddate() != null) {
			sql += " AND c.paiddate BETWEEN   '2000-01-01"
					+ "' AND '"
					+ ConsumeMgrImpl.formatDate(consumeListConditionBean
							.getEnddate()) + "' ";
		}
		if (consumeListConditionBean.getStartmoney() > 0) {
			sql += " AND c.actualmoney > "
					+ consumeListConditionBean.getStartmoney() + " ";
		}
		if (consumeListConditionBean.getEndmoney() > 0) {
			sql += " AND c.actualmoney < "
					+ consumeListConditionBean.getEndmoney() + " ";
		}
		String serviceitemcondition = assembleListServiceItems(consumeListConditionBean);
		if (!"".equals(serviceitemcondition)) {
			sql += "AND c.serviceitems LIKE '" + serviceitemcondition + "'";
		}
		return sql;
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

	private static String SERVICE_TYPE[] = { "repair", "maintain", "washing",
			"decorate", "insuranceconsult", "newcarregister",
			"crossplaceregister", "2handexchange" };

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

	private ConsumeVO getConsumeVO(ConsumeIDBean consumeIDBean,
			DBAgentOO dbAgentOO) throws Exception {
		ConsumeVO result = new ConsumeVO();
		result.setCorporationid(consumeIDBean.getCorporationid());
		result.setWhereCorporationid(true);
		result.setCustomerid(consumeIDBean.getCustomerid());
		result.setWhereCustomerid(true);
		result.setId(consumeIDBean.getConsumeid());
		result.setWhereId(true);
		result = (ConsumeVO) dbAgentOO.select(result);
		return result;
	}

	private CorporationVO getCorporationVO(ConsumeIDBean consumeIDBean,
			DBAgentOO dbAgentOO) throws Exception {
		CorporationVO result = new CorporationVO();
		result.setId(consumeIDBean.getCorporationid());
		result.setWhereId(true);
		result = (CorporationVO) dbAgentOO.select(result);
		return result;
	}

	public ConsumeBean getConsume(ConsumeIDBean consumeIDBean) throws Exception {
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		ConsumeBean result = null;
		try {
			dbAgentOO.beginTransaction();
			ContactVO contactVO = getContactVO(token.getContactid(), dbAgentOO);
			CarVO carVO = getCarVO(token.getAccountid(), dbAgentOO);
			String mobile = contactVO.getMobile();
			String platenumber = carVO.getPlatenumber();
			String sqlCheckCustomer = "SELECT id FROM customer WHERE platenumber = '"
					+ platenumber + "' AND mobile = '" + mobile + "' ";
			List customerIDList = dbAgentOO.selectSingleList(sqlCheckCustomer);
			boolean hasPrivilege = false;
			for(int i = 0; i < customerIDList.size(); i++){
				int customerID = Integer.parseInt(customerIDList.get(i).toString());
				if(consumeIDBean.getCustomerid() == customerID){
					hasPrivilege = true;
					break;
				}
			}
			if(!hasPrivilege){
				throw new CapiException(ExceptionKeys.NO_PRIVILEGE_REVIEW_CONSUME);
			}
			ConsumeVO consumeVO = getConsumeVO(consumeIDBean, dbAgentOO);
			CorporationVO corporationVO = this.getCorporationVO(consumeIDBean,
					dbAgentOO);
			result = getConsumeBean(consumeVO);
			result.setCorporationname(corporationVO.getName());
			result.setCorporationid(corporationVO.getId());
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

	private ConsumeBean getConsumeBean(ConsumeVO consumeVO) throws Exception {
		ConsumeBean result = new ConsumeBean();
		result.setConsumeid(consumeVO.getId());
		result.setCustomerid(consumeVO.getCustomerid());
		result.setOdometer(consumeVO.getOdometer());
		result.setSolution(consumeVO.getSolution());
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
}
