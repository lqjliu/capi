package com.carucrm.biz.carowner;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.carucrm.biz.NewResultBean;
import com.carucrm.biz.ResultBean;
import com.carucrm.biz.UpdateResultBean;
import com.carucrm.biz.carowner.LoginBean;
import com.carucrm.biz.carowner.LoginResultBean;
import com.carucrm.biz.register.CorporationRegisterBean;
import com.carucrm.util.AccountIDGenerator;
import com.carucrm.util.CarIDGenerator;
import com.carucrm.util.ContactIDGenerator;
import com.carucrm.vo.AccountVO;
import com.carucrm.vo.CarVO;
import com.carucrm.vo.ContactVO;
import com.carucrm.vo.CorporationVO;
import com.carucrm.vo.CustomerVO;
import com.common.db.DBAgentOO;
import com.common.exception.CapiException;
import com.common.exception.ExceptionKeys;
import com.common.web.RequestContext;
import com.common.web.Token;
import com.common.web.TokenUtil;
import com.sms.SMSUtil;

public class AccountMgrImpl {
	private static AccountMgrImpl instance = new AccountMgrImpl();
	private static final int INVALID_VERIFIED_CODE = 1;
	private static final int ACCOUNT_IS_EXISTED = 2;
	private static final int ACCOUNT_NAME_IS_NULL = 1;
	private static final int ACCOUNT_NAME_IS_DUPLICATED = 2;
	private static final int ACCOUNT_EMAIL_IS_DUPLICATED = 3;

	public static AccountMgrImpl getInstance() {
		return instance;
	}

	private AccountMgrImpl() {
	}

	public VerificationCodeResultBean verifyCode(String verifycode)
			throws Exception {
		VerificationCodeResultBean result = new VerificationCodeResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			CustomerVO customerVO = new CustomerVO();
			customerVO.setVerifycode(verifycode);
			customerVO.setWhereVerifycode(true);
			customerVO = (CustomerVO) dbAgentOO.select(customerVO);
			if (customerVO == null) {
				result.setErrorcode(INVALID_VERIFIED_CODE);
				result.setCmdstatus(false);
				return result;
			}
			String accountDuplicatedSql = "SELECT a.name FROM account a, contact b, car c WHERE"
					+ " a.contactid = b.id AND c.accountid = a.id AND a.type = 2 "
					+ " AND b.mobile = '"
					+ customerVO.getMobile()
					+ "' AND c.platenumber = '"
					+ customerVO.getPlatenumber()
					+ "'";
			String accountName = dbAgentOO
					.selectSingleValue(accountDuplicatedSql);
			if (accountName != null) {
				result.setErrorcode(ACCOUNT_IS_EXISTED);
				result.setCmdstatus(false);
				return result;
			}

			result.setCustomerid(customerVO.getId());
			CorporationVO coporationVO = getCorporationVO(customerVO
					.getCorporationid(), dbAgentOO);
			result.setBrandid(customerVO.getBrandid());
			result.setCityid(customerVO.getCityid());
			result.setCorporationid(customerVO.getCorporationid());
			result.setCorporationname(coporationVO.getName());
			result.setEmail(customerVO.getEmail());
			result.setModelid(customerVO.getModelid());
			result.setProvinceid(customerVO.getProvinceid());
			result.setRegistrydate(customerVO.getRegistrydate());
			result.setVendorid(customerVO.getVendorid());
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

	private CorporationVO getCorporationVO(int corporationID,
			DBAgentOO dbAgentOO) throws SQLException, Exception {
		CorporationVO corporationVO = new CorporationVO();
		corporationVO.setId(corporationID);
		corporationVO.setWhereId(true);
		corporationVO = (CorporationVO) dbAgentOO.select(corporationVO);
		return corporationVO;
	}

	private boolean registerValidateNull(AccountBean accountBean,
			NewResultBean newResultBean) {
		boolean result = true;
		if (accountBean.getName() == null || accountBean.getName().equals("")) {
			newResultBean.setErrorcode(ACCOUNT_NAME_IS_NULL);
			newResultBean.setCmdstatus(false);
			return false;
		}
		return result;
	}

	public boolean isCarOwnerAccountNameDuplicated(String accountName)
			throws Exception {
		boolean result = false;
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			result = isAccountNameDuplicated(dbAgentOO, accountName);
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

	private boolean isAccountNameDuplicated(DBAgentOO dbAgentOO,
			String accountName) throws Exception {
		boolean result = false;
		AccountVO accountVO = new AccountVO();
		accountVO.setName(accountName);
		accountVO.setWhereName(true);
		accountVO.setType(2);
		accountVO.setWhereType(true);
		accountVO = (AccountVO) dbAgentOO.select(accountVO);
		if (accountVO != null) {
			result = true;
		}
		return result;
	}

	public boolean isCarOwnerAccountEmailDuplicated(String accountEmail)
			throws Exception {
		boolean result = false;
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			result = isAccountEmailDuplicated(dbAgentOO, accountEmail);
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

	private final static int NO_VALID_VERIFIED_CODE = 1;

	public ResultBean sendVerifiedCode(String mobile) throws Exception {
		ResultBean result = new ResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			String sql = "SELECT verifycode FROM customer WHERE mobile = '13814838918' ORDER BY createdTime desc";
			String verifyCode = dbAgentOO.selectSingleValue(sql);
			if (verifyCode == null) {
				result.setCmdstatus(false);
				result.setErrorcode(NO_VALID_VERIFIED_CODE);
			}
			dbAgentOO.commitTransaction();
			SMSUtil.sendSM("你在CaruCRM的验证码 : " + verifyCode, mobile);
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

	private boolean isAccountEmailDuplicated(DBAgentOO dbAgentOO,
			String accountEmail) throws Exception {
		boolean result = false;
		AccountVO accountVO = new AccountVO();
		accountVO.setEmail(accountEmail);
		accountVO.setWhereEmail(true);
		accountVO.setType(2);
		accountVO.setWhereType(true);
		accountVO = (AccountVO) dbAgentOO.select(accountVO);
		if (accountVO != null) {
			result = true;
		}
		return result;
	}

	private boolean registerCarOwnerValidateDuplicated(DBAgentOO dbAgentOO,
			AccountBean accountBean, NewResultBean newResultBean)
			throws Exception {
		boolean result = false;
		if (isAccountNameDuplicated(dbAgentOO, accountBean.getName())) {
			newResultBean.setErrorcode(ACCOUNT_NAME_IS_DUPLICATED);
			newResultBean.setCmdstatus(false);
			return true;
		}
		if (accountBean.getEmail() != null) {
			if (isAccountEmailDuplicated(dbAgentOO, accountBean.getEmail())) {
				newResultBean.setErrorcode(ACCOUNT_EMAIL_IS_DUPLICATED);
				newResultBean.setCmdstatus(false);
				return true;
			}
		}
		return result;
	}

	public NewResultBean registerCarOwnerAccount(AccountBean accountBean)
			throws Exception {
		NewResultBean result = new NewResultBean();
		if (!registerValidateNull(accountBean, result)) {
			return result;
		}
		Date now = new Date();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			if (registerCarOwnerValidateDuplicated(dbAgentOO, accountBean,
					result)) {
				return result;
			}
			CustomerVO customerVO = new CustomerVO();
			customerVO.setId(accountBean.getCustomerid());
			customerVO.setWhereId(true);
			customerVO.setCorporationid(accountBean.getCorporationid());
			customerVO.setWhereCorporationid(true);
			customerVO = (CustomerVO) dbAgentOO.select(customerVO);
			int contactID = insertAccountContact(accountBean, customerVO,
					dbAgentOO, now);
			int accountID = insertCarOwnerAccount(accountBean, dbAgentOO, now,
					contactID);
			insertAccountCar(accountBean, customerVO, dbAgentOO, now, accountID);
			result.setId(accountID);
			customerVO = new CustomerVO();
			customerVO.setId(accountBean.getCustomerid());
			customerVO.setWhereId(true);
			customerVO.setCorporationid(accountBean.getCorporationid());
			customerVO.setWhereCorporationid(true);
			customerVO.setVerified(1);
			customerVO.setVerifycode(null);
			dbAgentOO.update(customerVO);
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

	private int insertAccountContact(AccountBean accountBean,
			CustomerVO customerVO, DBAgentOO dbAgentOO, Date now)
			throws SQLException, Exception {
		ContactVO contactVO = new ContactVO();
		contactVO.setName(customerVO.getName());
		contactVO.setMobile(customerVO.getMobile());
		contactVO.setId(ContactIDGenerator.getInstance().getId());
		contactVO.setType(3);
		contactVO.setActive(1);
		contactVO.setCreatedtime(now);
		contactVO.setLastmodifiedtime(now);
		dbAgentOO.insert(contactVO);
		return contactVO.getId();
	}

	private int insertCarOwnerAccount(AccountBean accountBean,
			DBAgentOO dbAgentOO, Date now, int contactID) throws SQLException,
			Exception {
		AccountVO accountVO = new AccountVO();
		accountVO.setId(AccountIDGenerator.getInstance().getId());
		accountVO.setActive(1);
		accountVO.setType(2);
		accountVO.setContactid(contactID);
		accountVO.setCreatedtime(now);
		accountVO.setLastmodifiedtime(now);
		accountVO.setPassword(accountBean.getPassword());
		accountVO.setName(accountBean.getName());
		accountVO.setEmail(accountBean.getEmail());
		dbAgentOO.insert(accountVO);
		return accountVO.getId();
	}

	private void insertAccountCar(AccountBean accountBean,
			CustomerVO customerVO, DBAgentOO dbAgentOO, Date now, int accountID)
			throws SQLException, Exception {
		CarVO carVO = new CarVO();
		carVO.setId(CarIDGenerator.getInstance().getId());
		carVO.setPlatenumber(customerVO.getPlatenumber());
		carVO.setProvinceid(accountBean.getProvinceid());
		carVO.setCityid(accountBean.getCityid());
		carVO.setVendorid(accountBean.getVendorid());
		carVO.setBrandid(accountBean.getBrandid());
		carVO.setModelid(accountBean.getModelid());
		carVO.setRegistrydate(accountBean.getRegistrydate());
		carVO.setAccountid(accountID);
		carVO.setActive(1);
		carVO.setCreatedtime(now);
		carVO.setLastmodifiedtime(now);
		dbAgentOO.insert(carVO);
	}

	private final static int USER_NAME_IS_NULL = 1;
	private final static int PASSWORD_IS_NULL = 2;
	private final static int ACCOUNT_IS_NOT_EXISTED = 3;
	private final static int PASSWORD_IS_NOT_VALID = 4;

	private boolean loginValidateNull(LoginBean loginBean,
			LoginResultBean loginResultBean) throws Exception {
		boolean result = true;
		if (loginBean.getAccountname() == null
				|| loginBean.getAccountname().equals("")) {
			loginResultBean.setErrorcode(USER_NAME_IS_NULL);
			loginResultBean.setCmdstatus(false);
			return false;
		}
		if (loginBean.getPassword() == null
				|| loginBean.getPassword().equals("")) {
			loginResultBean.setErrorcode(PASSWORD_IS_NULL);
			loginResultBean.setCmdstatus(false);
			return false;
		}
		return result;

	}

	public LoginResultBean loginAsCarOwner(LoginBean loginBean)
			throws Exception {
		LoginResultBean result = new LoginResultBean();
		if (!loginValidateNull(loginBean, result)) {
			return result;
		}
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			AccountVO accountVO = new AccountVO();
			accountVO.setName(loginBean.getAccountname());
			accountVO.setWhereName(true);
			accountVO.setType(2);
			accountVO.setWhereType(true);
			accountVO = (AccountVO) dbAgentOO.select(accountVO);
			if (accountVO == null) {
				accountVO = new AccountVO();
				accountVO.setEmail(loginBean.getAccountname());
				accountVO.setWhereEmail(true);
				accountVO.setType(2);
				accountVO.setWhereType(true);
				accountVO = (AccountVO) dbAgentOO.select(accountVO);
			}
			if (accountVO == null) {
				result.setErrorcode(ACCOUNT_IS_NOT_EXISTED);
				result.setCmdstatus(false);
			} else {
				if (!accountVO.getPassword().equals(loginBean.getPassword())) {
					result.setErrorcode(PASSWORD_IS_NOT_VALID);
					result.setCmdstatus(false);
				} else {
					Token token = new Token();
					token.setAccountid(accountVO.getId());
					token.setContactid(accountVO.getContactid());
					String ticket = TokenUtil.getTicket(token);
					result.setCredential(ticket);
				}
			}
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

	public CarOwnerAccountBean getCarOwnerAccountBean() throws Exception {
		CarOwnerAccountBean result = null;
		Token token = (Token) RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			AccountVO accountVO = getAccoutVO(token.getAccountid(), dbAgentOO);
			ContactVO accountContactVO = getContactVO(token.getContactid(),
					dbAgentOO);
			CarVO carVO = getCarVO(token.getAccountid(),dbAgentOO);
			String getCorporationSql = "SELECT a.id corporationid, a.name FROM corporation a, customer b WHERE"  
								+ " a.id = b.corporationid AND b.mobile = '" +accountContactVO.getMobile()+ "' " 
								+ "AND b.platenumber= '" +carVO.getPlatenumber()+ "'";
			List corporationList = dbAgentOO.selectData(getCorporationSql, "com.carucrm.biz.carowner.CorporationSumaryBean");
			result = assembleCarOwnerAccountBean(accountVO, carVO);
			result.setCorporationList(corporationList);
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

	private CarOwnerAccountBean assembleCarOwnerAccountBean(
			AccountVO accountVO, CarVO carVO) {
		CarOwnerAccountBean result = new CarOwnerAccountBean();
		result.setBrandid(carVO.getBrandid());
		result.setCarid(carVO.getId());
		result.setCityid(carVO.getCityid());
		result.setEmail(accountVO.getEmail());
		result.setModelid(carVO.getModelid());
		result.setName(accountVO.getName());
		result.setProvinceid(carVO.getProvinceid());
		result.setRegistrydate(carVO.getRegistrydate());
		result.setVendorid(carVO.getVendorid());
		return result;
	}
	
	private AccountVO getAccoutVO(int accountID, DBAgentOO dbAgentOO)
			throws SQLException, Exception {
		AccountVO accountVO = new AccountVO();
		accountVO.setId(accountID);
		accountVO.setWhereId(true);
		accountVO = (AccountVO) dbAgentOO.select(accountVO);
		return accountVO;
	}

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
	
	
	public ResultBean updateCarOwnerAccount(UpdateAccountBean updateAccountBean) throws Exception{
		ResultBean result = new ResultBean();
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			Date now = new Date();
			dbAgentOO.beginTransaction();
			AccountVO accountVO = getAccoutVO(token.getAccountid(), dbAgentOO);
			if(updateAccountBean.getEmail() != null && !updateAccountBean.getEmail().equals(accountVO.getEmail())){
				if(isAccountEmailDuplicated(dbAgentOO,updateAccountBean.getEmail())){
					result.setCmdstatus(false);
					result.setErrorcode(ACCOUNT_EMAIL_IS_DUPLICATED);
					return result;
				}
				accountVO = new AccountVO();
				accountVO.setId(token.getAccountid());
				accountVO.setWhereId(true);
				accountVO.setEmail(updateAccountBean.getEmail());
				accountVO.setLastmodifiedtime(now);
				dbAgentOO.update(accountVO);
			}
			CarVO carVO = new CarVO();
			carVO.setAccountid(token.getAccountid());
			carVO.setWhereAccountid(true);
			carVO.setProvinceid(updateAccountBean.getProvinceid());
			carVO.setCityid(updateAccountBean.getCityid());
			carVO.setVendorid(updateAccountBean.getVendorid());
			carVO.setBrandid(updateAccountBean.getBrandid());
			carVO.setModelid(updateAccountBean.getModelid());
			carVO.setRegistrydate(updateAccountBean.getRegistrydate());
			carVO.setLastmodifiedtime(now);
			dbAgentOO.update(carVO);
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
