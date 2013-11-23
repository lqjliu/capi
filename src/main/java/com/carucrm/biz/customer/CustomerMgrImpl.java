package com.carucrm.biz.customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.caru.exception.DataFormatInvalidException;
import com.carucrm.util.CustomerIDGenerator;
import com.carucrm.vo.CustomerVO;
import com.common.db.DBAgentOO;
import com.common.exception.CapiException;
import com.common.exception.ExceptionKeys;
import com.common.web.RequestContext;
import com.common.web.Token;

public class CustomerMgrImpl {
	private static CustomerMgrImpl instance = new CustomerMgrImpl();
	public static final int PLATENUMBER_IS_NULL = 1;
	public static final int PROVINCE_IS_NULL = 2;
	public static final int CITY_IS_NULL = 3;
	public static final int VENDOR_IS_NULL = 4;
	public static final int BRAND_IS_NULL = 5;
	public static final int MODEL_IS_NULL = 6;
	public static final int NAME_IS_NULL = 7;
	public static final int MOBILE_IS_NULL = 8;
	public static final int GENDER_IS_NULL = 9;
	public static final int MOBILE_IS_DUPLICATED = 10;

	
	private static Random random = new Random();
	public static CustomerMgrImpl getInstance() {
		return instance;
	}

	private CustomerMgrImpl() {
	}

	private boolean customerValidateNull(CustomerBean customerBean,
			CustomerResultBean addCustomerResultBean) {
		boolean result = true;
		if (customerBean.getPlatenumber() == null
				|| customerBean.getPlatenumber().equals("")) {
			addCustomerResultBean.setErrorcode(PLATENUMBER_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		if (customerBean.getProvinceid() == 0) {
			addCustomerResultBean.setErrorcode(PROVINCE_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		if (customerBean.getCityid() == 0) {
			addCustomerResultBean.setErrorcode(CITY_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		if (customerBean.getVendorid() == 0) {
			addCustomerResultBean.setErrorcode(VENDOR_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		if (customerBean.getBrandid() == 0) {
			addCustomerResultBean.setErrorcode(BRAND_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		if (customerBean.getModelid() == 0) {
			addCustomerResultBean.setErrorcode(MODEL_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		if (customerBean.getName() == null || customerBean.getName().equals("")) {
			addCustomerResultBean.setErrorcode(NAME_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		if (customerBean.getMobile() == null
				|| customerBean.getMobile().equals("")) {
			addCustomerResultBean.setErrorcode(MOBILE_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		if (customerBean.getGender() == 0) {
			addCustomerResultBean.setErrorcode(GENDER_IS_NULL);
			addCustomerResultBean.setCmdstatus(false);
			return false;
		}
		return result;
	}

	private boolean isMobileDuplicated(DBAgentOO dbAgentOO, String mobile,
			Token token) throws Exception {
		boolean result = false;
		CustomerVO customerVO = new CustomerVO();
		customerVO.setMobile(mobile);
		customerVO.setWhereMobile(true);
		customerVO.setCorporationid(token.getCorporationid());
		customerVO.setWhereCorporationid(true);
		customerVO = (CustomerVO) dbAgentOO.select(customerVO);
		if (customerVO != null) {
			result = true;
		}
		return result;
	}

	public boolean isMobileDuplicated(String mobile) throws Exception {
		boolean result = false;
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			result = isMobileDuplicated(dbAgentOO, mobile, token);
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

	private boolean addCustomerValidateDuplicated(DBAgentOO dbAgentOO,
			CustomerBean customerBean, Token token,
			CustomerResultBean addCustomerResultBean) throws Exception {
		boolean result = false;
		if (isMobileDuplicated(dbAgentOO, customerBean.getMobile(), token)) {
			addCustomerResultBean.setErrorcode(MOBILE_IS_DUPLICATED);
			addCustomerResultBean.setCmdstatus(false);
			return true;
		}
		return result;
	}

	private CustomerVO getCustomerVO(Token token, CustomerBean customerBean,
			Date now) {
		CustomerVO result = new CustomerVO();
		result.setActive(1);
		result.setBrandid(customerBean.getBrandid());
		result.setCityid(customerBean.getCityid());
		result.setCreatedtime(now);
		result.setGender(customerBean.getGender());
		result.setLastmodifiedtime(now);
		result.setMobile(customerBean.getMobile());
		result.setModelid(customerBean.getModelid());
		result.setName(customerBean.getName());
		result.setPlatenumber(customerBean.getPlatenumber());
		result.setProvinceid(customerBean.getProvinceid());
		result.setRegistrydate(customerBean.getRegistrydate());
		result.setRemark(customerBean.getRemark());
		result.setVendorid(customerBean.getVendorid());
		result.setCorporationid(token.getCorporationid());
		int verifyCode = random.nextInt();
		if(verifyCode < 0){
			verifyCode = verifyCode * (-1);
		}
		result.setVerifycode(verifyCode + "");
		return result;
	}


	private CustomerBean getCustomerBean(CustomerVO customerVO) {
		CustomerBean result = new CustomerBean();
		result.setBrandid(customerVO.getBrandid());
		result.setCityid(customerVO.getCityid());
		result.setGender(customerVO.getGender());
		result.setMobile(customerVO.getMobile());
		result.setModelid(customerVO.getModelid());
		result.setName(customerVO.getName());
		result.setPlatenumber(customerVO.getPlatenumber());
		result.setProvinceid(customerVO.getProvinceid());
		result.setRegistrydate(customerVO.getRegistrydate());
		result.setRemark(customerVO.getRemark());
		result.setVendorid(customerVO.getVendorid());
		result.setCustomerid(customerVO.getId());
		return result;
	}

	private CustomerVO getCustomerVO(Token token, int customerID,
			DBAgentOO dbAgentOO) throws Exception {
		CustomerVO result = new CustomerVO();
		result.setCorporationid(token.getCorporationid());
		result.setWhereCorporationid(true);
		result.setId(customerID);
		result.setWhereId(true);
		result = (CustomerVO) dbAgentOO.select(result);
		return result;
	}

	public CustomerResultBean addCustomer(CustomerBean customerBean)
			throws Exception {
		CustomerResultBean result = new CustomerResultBean();
		if (!customerValidateNull(customerBean, result)) {
			return result;
		}
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			Date now = new Date();
			dbAgentOO.beginTransaction();
			if (addCustomerValidateDuplicated(dbAgentOO, customerBean, token,
					result)) {
				return result;
			}
			CustomerVO customerVO = getCustomerVO(token, customerBean, now);
			int customerID = CustomerIDGenerator.getInstance().getId();
			
			customerVO.setId(customerID);
			dbAgentOO.insert(customerVO);
			dbAgentOO.commitTransaction();
			result.setCustomerid(customerID);
			result.setVerifycode(customerVO.getVerifycode());
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

	public CustomerResultBean editCustomer(CustomerBean customerBean)
			throws Exception {
		CustomerResultBean result = new CustomerResultBean();
		if (!customerValidateNull(customerBean, result)) {
			return result;
		}
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			Date now = new Date();
			dbAgentOO.beginTransaction();
			CustomerVO orginalCustomerVO = getCustomerVO(token, customerBean
					.getCustomerid(), dbAgentOO);
			if (orginalCustomerVO == null) {
				throw new RuntimeException("Invalid customer ID");
			}
			if (!orginalCustomerVO.getMobile().equals(customerBean.getMobile())) {
				if (addCustomerValidateDuplicated(dbAgentOO, customerBean,
						token, result)) {
					return result;
				}
			}
			CustomerVO customerVO = getCustomerVO(token, customerBean, now);
			customerVO.setId(customerBean.getCustomerid());
			customerVO.setWhereId(true);
			customerVO.setWhereCorporationid(true);
			dbAgentOO.update(customerVO);
			dbAgentOO.commitTransaction();
			result.setCustomerid(customerBean.getCustomerid());
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

	public CustomerBean getCustomer(CustomerIDBean customerIDBean)
			throws Exception {
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		CustomerBean result = null;
		try {
			Date now = new Date();
			dbAgentOO.beginTransaction();
			CustomerVO customerVO = getCustomerVO(token, customerIDBean
					.getCustomerid(), dbAgentOO);
			dbAgentOO.commitTransaction();
			if (customerVO == null) {
				throw new CapiException(ExceptionKeys.CUSTOMER_IS_NOT_EXISTED);
			}
			result = this.getCustomerBean(customerVO);
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

	public void deleteCustomer(CustomerIDBean customerIDBean) throws Exception {
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			CustomerVO customerVO = new CustomerVO();
			customerVO.setId(customerIDBean.getCustomerid());
			customerVO.setWhereId(true);
			customerVO.setCorporationid(token.getCorporationid());
			customerVO.setWhereCorporationid(true);
			dbAgentOO.delete(customerVO);
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

	private static final int SUGGEST_NOTHING = 1;
	private static final int SUGGEST_NAME = 2;
	private static final int SUGGEST_MOBILE = 3;
	private static final int SUGGEST_PLATENUMBER = 4;

	private String getSuggestCondition(String keyword,
			SuggestCustomerResultBean suggestCustomerResultBean) {
		String result = null;
		if (keyword.length() == 1) {
			suggestCustomerResultBean.setSuggestKeywordType(SUGGEST_NOTHING);
			return null;
		} else if (keyword.length() == 2) {
			char c1 = keyword.charAt(0);
			char c2 = keyword.charAt(1);
			if (c1 > 0x80 && c2 > 0x80) {
				suggestCustomerResultBean.setSuggestKeywordType(SUGGEST_NAME);
				result = "name like '" + keyword.toUpperCase() + "%'";
			} else {
				suggestCustomerResultBean
						.setSuggestKeywordType(SUGGEST_NOTHING);
			}
		} else if (keyword.length() >= 3) {
			if (keyword.charAt(0) > 0x80 && keyword.charAt(1) > 0x80) {
				suggestCustomerResultBean.setSuggestKeywordType(SUGGEST_NAME);
				result = " name like '" + keyword.toUpperCase() + "%'";
			} else if (keyword.charAt(0) > 0x80 && keyword.charAt(1) >= 65
					&& keyword.charAt(1) <= 90) {
				suggestCustomerResultBean
						.setSuggestKeywordType(SUGGEST_PLATENUMBER);
				result = " platenumber like '" + keyword.toUpperCase() + "%'";
			} else if (keyword.length() >= 4) {
				char ch1 = keyword.charAt(0);
				char ch2 = keyword.charAt(1);
				char ch3 = keyword.charAt(2);
				char ch4 = keyword.charAt(3);
				if (ch1 >= 48 && ch1 <= 57 && ch2 >= 48 && ch2 <= 57
						&& ch3 >= 48 && ch3 <= 57 && ch4 >= 48 && ch4 <= 57) {
					suggestCustomerResultBean
							.setSuggestKeywordType(SUGGEST_MOBILE);
					result = " mobile like '" + keyword.toUpperCase() + "%'";
				}
			} else {
				suggestCustomerResultBean
						.setSuggestKeywordType(SUGGEST_NOTHING);
			}
		}
		return result;
	}

	public SuggestCustomerResultBean suggestCustomer(String keyword)
			throws Exception {
		SuggestCustomerResultBean result = new SuggestCustomerResultBean();
		String condition = getSuggestCondition(keyword, result);
		if (condition == null) {
			return result;
		}
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			String sql = "SELECT id customerid, NAME,platenumber,mobile FROM customer "
					+ "WHERE corporationid = "
					+ token.getCorporationid()
					+ " AND " + condition;
			List list = dbAgentOO.selectData(sql,
					"com.carucrm.biz.customer.SuggestCustomerBean", 1,
					ROW_COUNT_PER_PAGE);
			result.setSuggestCustomerList(list);
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

	private final int ROW_COUNT_PER_PAGE = 20;

	public SearchCustomerResultBean searchCustomer(
			SearchCustomerInputBean inputBean) throws Exception {
		SearchCustomerResultBean result = new SearchCustomerResultBean();
		String keyword = inputBean.getKeyword().toUpperCase();
		String condition = " (name like '%" + keyword
				+ "%' or platenumber like '%" + keyword
				+ "%' or mobile like '%" + keyword + "%') ";

		if (inputBean.getOrderby() != null
				&& !"".equals(inputBean.getOrderby())) {
			String orderBy = " order by "
					+ inputBean.getOrderby().toLowerCase();
			if (inputBean.getOrderway() == 0) {
				orderBy += (" asc");
			} else {
				orderBy += (" desc");
			}
			condition += orderBy;
		}
		return getCustomerList(inputBean.getCurrentpageno(), result, condition);
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

	private final static int LATEST_DURATION = 3;

	public SearchCustomerResultBean getLatestCustomer(
			LatestCustomerInputBean latestCustomerInputBean) throws Exception {
		SearchCustomerResultBean result = new SearchCustomerResultBean();
		Date now = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
		Date latestStartPoint = new Date(System.currentTimeMillis()
				- LATEST_DURATION * 24 * 60 * 60 * 1000);
		String snow = formatDate(now);
		String sLatestStartPoint = formatDate(latestStartPoint);
		String condition = " latestconsumedate BETWEEN '" + sLatestStartPoint
				+ "' AND '" + snow + "' ";

		if (latestCustomerInputBean.getOrderby() != null
				&& !"".equals(latestCustomerInputBean.getOrderby())) {
			String orderBy = " order by "
					+ latestCustomerInputBean.getOrderby().toLowerCase();
			if (latestCustomerInputBean.getOrderway() == 0) {
				orderBy += (" asc");
			} else {
				orderBy += (" desc");
			}
			condition += orderBy;
		}

		return getCustomerList(latestCustomerInputBean.getCurrentpageno(),
				result, condition);
	}

	public SearchCustomerResultBean getCertainCustomer(
			CustomerIDBean customerIDBean) throws Exception {
		SearchCustomerResultBean result = new SearchCustomerResultBean();
		String condition = " id = " + customerIDBean.getCustomerid();
		return getCustomerList(1, result, condition);
	}

	private SearchCustomerResultBean getCustomerList(int currentPageNo,
			SearchCustomerResultBean result, String condition) throws Exception {
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			String sqlRecordcount = "SELECT count(id) FROM customer "
					+ "WHERE corporationid = " + token.getCorporationid()
					+ " AND " + condition;

			String sCount = dbAgentOO.selectSingleValue(sqlRecordcount);
			int count = Integer.parseInt(sCount);
			int pageSize = 0;
			if (count % ROW_COUNT_PER_PAGE == 0) {
				pageSize = count / ROW_COUNT_PER_PAGE;
			} else {
				pageSize = count / ROW_COUNT_PER_PAGE + 1;
			}
			result.setPagesize(pageSize);
			int pos = (currentPageNo - 1) * ROW_COUNT_PER_PAGE;
			String sql = "SELECT id customerid, NAME,platenumber,mobile,cumulatemoney,"
					+ "latestconsumedate, latestconsumemoney FROM customer "
					+ "WHERE corporationid = "
					+ token.getCorporationid()
					+ " AND " + condition;
			List list = dbAgentOO.selectData(sql,
					"com.carucrm.biz.customer.SearchCustomerBean", pos,
					ROW_COUNT_PER_PAGE);
			result.setSearchCustomerList(list);
			result.setCurrentpageno(currentPageNo);
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

}
