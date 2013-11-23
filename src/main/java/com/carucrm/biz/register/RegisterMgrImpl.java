package com.carucrm.biz.register;

import java.sql.SQLException;
import java.util.Date;

import com.caru.util.StringUtil;
import com.carucrm.biz.UpdateResultBean;
import com.carucrm.util.AccountIDGenerator;
import com.carucrm.util.ContactIDGenerator;
import com.carucrm.util.CorporationIDGenerator;
import com.carucrm.vo.AccountVO;
import com.carucrm.vo.ContactVO;
import com.carucrm.vo.CorporationVO;
import com.common.db.DBAgentOO;
import com.common.exception.CapiException;
import com.common.exception.ExceptionKeys;
import com.common.web.RequestContext;
import com.common.web.Token;

public class RegisterMgrImpl {
	private static RegisterMgrImpl instance = new RegisterMgrImpl();
	private static String SERVICE_TYPE[] = { "repair", "maintain", "washing",
			"decorate", "insuranceconsult", "newcarregister",
			"crossplaceregister", "2handexchange" };

	public static RegisterMgrImpl getInstance() {
		return instance;
	}

	private RegisterMgrImpl() {
	}

	private void registerCorporationValidateNull(
			CorporationRegisterBean register) throws Exception {
		registerCorporationValidateNull(register, false);
	}

	private void registerCorporationValidateNull(
			CorporationRegisterBean register, boolean isEdit) throws Exception {
		if (!isEdit) {
			if (register.getSymbol() == null || register.getSymbol().equals("")) {
				throw new CapiException(ExceptionKeys.SYMBOL_IS_NULL);
			}
		}
		if (register.getName() == null || register.getName().equals("")) {
			throw new CapiException(ExceptionKeys.NAME_IS_NULL);
		}
		if (register.getContactname() == null
				|| register.getContactname().equals("")) {
			throw new CapiException(ExceptionKeys.CONTACTNAME_IS_NULL);
		}
		if (register.getContactmobile() == null
				|| register.getContactmobile().equals("")) {
			throw new CapiException(ExceptionKeys.CONTACTMOBILE_IS_NULL);
		}
		if (!isEdit) {
			if (register.getAccountname() == null
					|| register.getAccountname().equals("")) {
				throw new CapiException(ExceptionKeys.ACCOUNTNAME_IS_NULL);
			}
			if (register.getAccountpassword() == null
					|| register.getAccountpassword().equals("")) {
				throw new CapiException(ExceptionKeys.ACCOUNTPASSWORD_IS_NULL);
			}
		}

		if (register.getAccountcontactname() == null
				|| register.getAccountcontactname().equals("")) {
			throw new CapiException(ExceptionKeys.ACCOUNTCONTACTNAME_IS_NULL);
		}
		if (register.getContactmobile() == null
				|| register.getContactmobile().equals("")) {
			throw new CapiException(ExceptionKeys.ACCOUNTCONTACTMOBILE_IS_NULL);
		}
	}

	private void registerCorporationValidateDuplication(DBAgentOO dbAgentOO,
			CorporationRegisterBean register) throws Exception {
		if (isSymbolDuplicated(dbAgentOO, register.getSymbol())) {
			throw new CapiException(ExceptionKeys.SYMBOL_IS_DUPLICATED);
		}
		if (isContactMobileDuplicated(dbAgentOO, register.getContactmobile())) {
			throw new CapiException(ExceptionKeys.CONTACTMOBILE_IS_DUPLICATED);
		}
		if (isAccountNameDuplicated(dbAgentOO, register.getAccountname())) {
			throw new CapiException(ExceptionKeys.ACCOUNTNAME_IS_DUPLICATED);
		}
		if (register.getAccountemail() != null
				&& !register.getAccountemail().equals("")) {
			if (isAccountEmailDuplicated(dbAgentOO, register.getAccountemail())) {
				throw new CapiException(
						ExceptionKeys.ACCOUNTEMAIL_IS_DUPLICATED);
			}
		}
		if (isAccountContactMobileDuplicated(dbAgentOO, register
				.getAccountcontactmobile())) {
			throw new CapiException(
					ExceptionKeys.ACCOUNTCONTACTMOBILE_IS_DUPLICATED);
		}

	}

	private void updateCorporationRegisterationValidateDuplication(
			DBAgentOO dbAgentOO, CorporationRegisterBean register,
			CorporationVO corporationVO, ContactVO corporationContactVO,
			AccountVO accountVO, ContactVO accountContactVO) throws Exception {
		// if (!register.getSymbol().equals(corporationVO.getSymbol())) {
		// if (isSymbolDuplicated(dbAgentOO, register.getSymbol())) {
		// throw new CapiException(ExceptionKeys.SYMBOL_IS_DUPLICATED);
		// }
		// }
		if (!register.getContactmobile().equals(
				corporationContactVO.getMobile())) {
			if (isContactMobileDuplicated(dbAgentOO, register
					.getContactmobile())) {
				throw new CapiException(
						ExceptionKeys.CONTACTMOBILE_IS_DUPLICATED);
			}
		}
		// if (!register.getAccountname().equals(accountVO.getName())) {
		// if (isAccountNameDuplicated(dbAgentOO, register.getAccountname())) {
		// throw new CapiException(ExceptionKeys.ACCOUNTNAME_IS_DUPLICATED);
		// }
		// }

		if (register.getAccountemail() != null
				&& !register.getAccountemail().equals("")) {
			if (!register.getAccountemail().equals(accountVO.getEmail())) {
				if (isAccountEmailDuplicated(dbAgentOO, register
						.getAccountemail())) {
					throw new CapiException(
							ExceptionKeys.ACCOUNTEMAIL_IS_DUPLICATED);
				}
			}
		}

		if (!register.getAccountcontactmobile().equals(
				accountContactVO.getMobile())) {
			if (isAccountContactMobileDuplicated(dbAgentOO, register
					.getAccountcontactmobile())) {
				throw new CapiException(
						ExceptionKeys.ACCOUNTCONTACTMOBILE_IS_DUPLICATED);
			}
		}

	}

	public boolean isSymbolDuplicated(String symbol) throws Exception {
		boolean result = false;
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			result = isSymbolDuplicated(dbAgentOO, symbol);
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

	private boolean isSymbolDuplicated(DBAgentOO dbAgentOO, String symbol)
			throws Exception {
		boolean result = false;
		CorporationVO corporationVO = new CorporationVO();
		corporationVO.setSymbol(symbol);
		corporationVO.setWhereSymbol(true);
		corporationVO = (CorporationVO) dbAgentOO.select(corporationVO);
		if (corporationVO != null) {
			result = true;
		}
		return result;
	}

	public boolean isContactMobileDuplicated(String contactMobile)
			throws Exception {
		boolean result = false;
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			result = isContactMobileDuplicated(dbAgentOO, contactMobile);
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

	private boolean isContactMobileDuplicated(DBAgentOO dbAgentOO,
			String contactMobile) throws Exception {
		boolean result = false;
		ContactVO contactVO = new ContactVO();
		contactVO.setMobile(contactMobile);
		contactVO.setWhereMobile(true);
		contactVO.setType(1);
		contactVO.setWhereType(true);
		contactVO = (ContactVO) dbAgentOO.select(contactVO);
		if (contactVO != null) {
			result = true;
		}
		return result;
	}

	public boolean isAccountNameDuplicated(String accountName) throws Exception {
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
		accountVO.setType(1);
		accountVO.setWhereType(true);
		accountVO = (AccountVO) dbAgentOO.select(accountVO);
		if (accountVO != null) {
			result = true;
		}
		return result;
	}

	public boolean isAccountEmailDuplicated(String accountEmail)
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

	private boolean isAccountEmailDuplicated(DBAgentOO dbAgentOO,
			String accountEmail) throws Exception {
		boolean result = false;
		AccountVO accountVO = new AccountVO();
		accountVO.setEmail(accountEmail);
		accountVO.setWhereEmail(true);
		accountVO.setType(1);
		accountVO.setWhereType(true);
		accountVO = (AccountVO) dbAgentOO.select(accountVO);
		if (accountVO != null) {
			result = true;
		}
		return result;
	}

	public boolean isAccountContactMobileDuplicated(String accountContactMobile)
			throws Exception {
		boolean result = false;
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			result = isAccountContactMobileDuplicated(dbAgentOO,
					accountContactMobile);
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

	private boolean isAccountContactMobileDuplicated(DBAgentOO dbAgentOO,
			String accountContactMobile) throws Exception {
		boolean result = false;
		ContactVO contactVO = new ContactVO();
		contactVO.setMobile(accountContactMobile);
		contactVO.setWhereMobile(true);
		contactVO.setType(2);
		contactVO.setWhereType(true);
		contactVO = (ContactVO) dbAgentOO.select(contactVO);
		if (contactVO != null) {
			result = true;
		}
		return result;
	}

	public CorporationRegisterResultBean registerCorporation(
			CorporationRegisterBean register) throws Exception {
		registerCorporationValidateNull(register);
		CorporationRegisterResultBean result = new CorporationRegisterResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			Date now = new Date();
			dbAgentOO.beginTransaction();
			registerCorporationValidateDuplication(dbAgentOO, register);
			int corporationContactID = insertCorporationContact(register,
					dbAgentOO, now);
			int corporationID = insertCorporation(register, dbAgentOO, now,
					corporationContactID);
			int accountContactID = insertAccountContact(register, dbAgentOO,
					now);
			insertAccount(register, dbAgentOO, now, accountContactID,
					corporationID);
			dbAgentOO.commitTransaction();
			result.setCorporationid(corporationID);
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

	private void insertAccount(CorporationRegisterBean register,
			DBAgentOO dbAgentOO, Date now, int accountContactID,
			int corporationID) throws SQLException, Exception {
		AccountVO accountVO = new AccountVO();
		accountVO.setId(AccountIDGenerator.getInstance().getId());
		accountVO.setActive(1);
		accountVO.setType(1);
		accountVO.setRole(1);
		accountVO.setContactid(accountContactID);
		accountVO.setCreatedtime(now);
		accountVO.setLastmodifiedtime(now);
		accountVO.setCorporationid(corporationID);
		accountVO.setPassword(register.getAccountpassword());
		accountVO.setName(register.getAccountname());
		accountVO.setEmail(register.getAccountemail());
		dbAgentOO.insert(accountVO);
	}

	private void updateAccount(CorporationRegisterBean register,
			DBAgentOO dbAgentOO, Date now, int accountID) throws SQLException,
			Exception {
		AccountVO accountVO = new AccountVO();
		accountVO.setId(accountID);
		accountVO.setWhereId(true);
		accountVO.setLastmodifiedtime(now);
		// accountVO.setName(register.getAccountname());
		accountVO.setEmail(register.getAccountemail());
		dbAgentOO.update(accountVO);
	}

	private int insertCorporation(CorporationRegisterBean register,
			DBAgentOO dbAgentOO, Date now, int corporationContactID)
			throws SQLException, Exception {
		CorporationVO corporationVO = new CorporationVO();
		corporationVO.setCreatedtime(now);
		corporationVO.setLastmodifiedtime(now);
		corporationVO.setId(CorporationIDGenerator.getInstance().getId());
		corporationVO.setSymbol(register.getSymbol());
		corporationVO.setContactid(corporationContactID);
		corporationVO.setName(register.getName());
		corporationVO.setProvinceid(register.getProvinceid());
		corporationVO.setCityid(register.getCityid());
		corporationVO.setCountyid(register.getCountyid());
		corporationVO.setAddress(register.getAddress());
		corporationVO.setPlatenumberprefix(register.getPlatenumberprefix());
		corporationVO.setCsphone1areacode(register.getCsphone1areacode());
		corporationVO.setCsphone1(register.getCsphone1());
		corporationVO.setCsphone2areacode(register.getCsphone2areacode());
		corporationVO.setCsphone2(register.getCsphone2());
		corporationVO.setActive(1);
		assembleServiceItems(register, corporationVO);
		dbAgentOO.insert(corporationVO);
		return corporationVO.getId();
	}

	private void updatgeCorporation(CorporationRegisterBean register,
			DBAgentOO dbAgentOO, Date now, int corporationid)
			throws SQLException, Exception {
		CorporationVO corporationVO = new CorporationVO();
		corporationVO.setId(corporationid);
		corporationVO.setWhereId(true);
		corporationVO.setLastmodifiedtime(now);
		// corporationVO.setSymbol(register.getSymbol());
		corporationVO.setName(register.getName());
		corporationVO.setProvinceid(register.getProvinceid());
		corporationVO.setCityid(register.getCityid());
		corporationVO.setCountyid(register.getCountyid());
		corporationVO.setAddress(register.getAddress());
		corporationVO.setPlatenumberprefix(register.getPlatenumberprefix());
		corporationVO.setCsphone1areacode(register.getCsphone1areacode());
		corporationVO.setCsphone1(register.getCsphone1());
		corporationVO.setCsphone2areacode(register.getCsphone2areacode());
		corporationVO.setCsphone2(register.getCsphone2());
		assembleServiceItems(register, corporationVO);
		dbAgentOO.update(corporationVO);
	}

	private void assembleServiceItems(CorporationRegisterBean register,
			CorporationVO corporationVO) {
		int serviceOptions[] = new int[8];
		serviceOptions[0] = register.getSupportrepair();
		serviceOptions[1] = register.getSupportmaintain();
		serviceOptions[2] = register.getSupportwashing();
		serviceOptions[3] = register.getSupportdecorate();
		serviceOptions[4] = register.getSupportinsuranceconsult();
		serviceOptions[5] = register.getSupportnewcarregister();
		serviceOptions[6] = register.getSupportcrossplaceregister();
		serviceOptions[7] = register.getSupport2handexchange();
		String serviceItems = "";
		for (int i = 0; i < 8; i++) {
			if (i != 0) {
				serviceItems += ",";
			}
			serviceItems += (SERVICE_TYPE[i] + "=" + serviceOptions[i]);
		}
		corporationVO.setServiceitems(serviceItems);
	}

	private void revertServiceItems(CorporationRegisterBean register,
			CorporationVO corporationVO) {

		String serviceItems = corporationVO.getServiceitems();
		String[] serviceItemss = StringUtil.splitString(serviceItems, ",");
		int serviceOptions[] = new int[8];
		for (int i = 0; i < 8; i++) {
			String service = serviceItemss[i];
			serviceOptions[i] = Integer.parseInt(service.substring(
					service.indexOf("=") + 1).trim());
		}
		register.setSupportrepair(serviceOptions[0]);
		register.setSupportmaintain(serviceOptions[1]);
		register.setSupportwashing(serviceOptions[2]);
		register.setSupportdecorate(serviceOptions[3]);
		register.setSupportinsuranceconsult(serviceOptions[4]);
		register.setSupportnewcarregister(serviceOptions[5]);
		register.setSupportcrossplaceregister(serviceOptions[6]);
		register.setSupport2handexchange(serviceOptions[7]);

	}

	private int insertAccountContact(CorporationRegisterBean register,
			DBAgentOO dbAgentOO, Date now) throws SQLException, Exception {
		ContactVO contactVO1 = new ContactVO();
		contactVO1.setName(register.getAccountcontactname());
		contactVO1.setMobile(register.getAccountcontactmobile());
		contactVO1.setId(ContactIDGenerator.getInstance().getId());
		contactVO1.setType(2);
		contactVO1.setActive(1);
		contactVO1.setCreatedtime(now);
		contactVO1.setLastmodifiedtime(now);
		dbAgentOO.insert(contactVO1);
		return contactVO1.getId();
	}

	private void updateAccountContact(CorporationRegisterBean register,
			DBAgentOO dbAgentOO, Date now, int contactID) throws SQLException,
			Exception {
		ContactVO contactVO1 = new ContactVO();
		contactVO1.setId(contactID);
		contactVO1.setWhereId(true);
		contactVO1.setName(register.getAccountcontactname());
		contactVO1.setMobile(register.getAccountcontactmobile());
		contactVO1.setLastmodifiedtime(now);
		dbAgentOO.update(contactVO1);
	}

	private int insertCorporationContact(CorporationRegisterBean register,
			DBAgentOO dbAgentOO, Date now) throws SQLException, Exception {
		ContactVO contactVO = new ContactVO();
		contactVO.setName(register.getContactname());
		contactVO.setMobile(register.getContactmobile());
		contactVO.setId(ContactIDGenerator.getInstance().getId());
		contactVO.setType(1);
		contactVO.setActive(1);
		contactVO.setCreatedtime(now);
		contactVO.setLastmodifiedtime(now);
		dbAgentOO.insert(contactVO);
		return contactVO.getId();
	}

	private void updateCorporationContact(CorporationRegisterBean register,
			DBAgentOO dbAgentOO, Date now, int contactID) throws SQLException,
			Exception {
		ContactVO contactVO = new ContactVO();
		contactVO.setId(contactID);
		contactVO.setWhereId(true);
		contactVO.setName(register.getContactname());
		contactVO.setMobile(register.getContactmobile());
		contactVO.setLastmodifiedtime(now);
		dbAgentOO.update(contactVO);
	}

	public CorporationRegisterBean getCorporationRegisteration()
			throws Exception {
		CorporationRegisterBean result = null;
		Token token = (Token) RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			CorporationVO corporationVO = getCorporationVO(token
					.getCorporationid(), dbAgentOO);
			ContactVO corporationContactVO = getContactVO(corporationVO
					.getContactid(), dbAgentOO);
			AccountVO accountVO = getAccoutVO(token.getAccountid(), dbAgentOO);
			ContactVO accountContactVO = getContactVO(token.getContactid(),
					dbAgentOO);
			result = assembleCorporationRegisterBean(corporationVO,
					corporationContactVO, accountVO, accountContactVO);
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

	private CorporationRegisterBean assembleCorporationRegisterBean(
			CorporationVO corporationVO, ContactVO corprationContactVO,
			AccountVO accountVO, ContactVO accountContactVO) {
		CorporationRegisterBean result = new CorporationRegisterBean();
		result.setSymbol(corporationVO.getSymbol());
		result.setName(corporationVO.getName());
		result.setProvinceid(corporationVO.getProvinceid());
		result.setCityid(corporationVO.getCityid());
		result.setCountyid(corporationVO.getCountyid());
		result.setAddress(corporationVO.getAddress());
		result.setPlatenumberprefix(corporationVO.getPlatenumberprefix());
		result.setCsphone1areacode(corporationVO.getCsphone1areacode());
		result.setCsphone1(corporationVO.getCsphone1());
		result.setCsphone2areacode(corporationVO.getCsphone2areacode());
		result.setCsphone2(corporationVO.getCsphone2());
		revertServiceItems(result, corporationVO);

		result.setContactname(corprationContactVO.getName());
		result.setContactmobile(corprationContactVO.getMobile());

		// result.setAccountpassword(accountVO.getPassword());
		result.setAccountname(accountVO.getName());
		result.setAccountemail(accountVO.getEmail());

		result.setAccountcontactname(accountContactVO.getName());
		result.setAccountcontactmobile(accountContactVO.getMobile());
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

	private ContactVO getContactVO(int contactID, DBAgentOO dbAgentOO)
			throws SQLException, Exception {
		ContactVO contactVO = new ContactVO();
		contactVO.setId(contactID);
		contactVO.setWhereId(true);
		contactVO = (ContactVO) dbAgentOO.select(contactVO);
		return contactVO;
	}

	private AccountVO getAccoutVO(int accountID, DBAgentOO dbAgentOO)
			throws SQLException, Exception {
		AccountVO accountVO = new AccountVO();
		accountVO.setId(accountID);
		accountVO.setWhereId(true);
		accountVO = (AccountVO) dbAgentOO.select(accountVO);
		return accountVO;
	}

	public UpdateResultBean updateCorporationRegisteration(
			CorporationRegisterBean register) throws Exception {
		UpdateResultBean result = new UpdateResultBean();
		registerCorporationValidateNull(register, true);
		Token token = RequestContext.getToken();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			Date now = new Date();
			dbAgentOO.beginTransaction();
			CorporationVO corporationVO = getCorporationVO(token
					.getCorporationid(), dbAgentOO);
			ContactVO corporationContactVO = getContactVO(corporationVO
					.getContactid(), dbAgentOO);
			AccountVO accountVO = getAccoutVO(token.getAccountid(), dbAgentOO);
			ContactVO accountContactVO = getContactVO(token.getContactid(),
					dbAgentOO);
			updateCorporationRegisterationValidateDuplication(dbAgentOO,
					register, corporationVO, corporationContactVO, accountVO,
					accountContactVO);
			updateCorporationContact(register, dbAgentOO, now,
					corporationContactVO.getId());
			updatgeCorporation(register, dbAgentOO, now, token
					.getCorporationid());
			updateAccountContact(register, dbAgentOO, now, token.getContactid());
			updateAccount(register, dbAgentOO, now, token.getAccountid());
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
