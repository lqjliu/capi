package com.carucrm.biz.account;

import java.sql.SQLException;

import com.carucrm.vo.AccountVO;
import com.common.db.DBAgentOO;
import com.common.exception.CapiException;
import com.common.exception.ExceptionKeys;
import com.common.web.RequestContext;
import com.common.web.Token;

public class AccountMgrImpl {
	private static AccountMgrImpl instance = new AccountMgrImpl();

	public static AccountMgrImpl getInstance() {
		return instance;
	}

	private AccountMgrImpl() {
	}

	private void changePasswordValidateNull(
			ChangePasswordBean changePasswordBean) throws Exception {
		if (changePasswordBean.getNewpassword() == null
				|| changePasswordBean.getNewpassword().equals("")) {
			throw new CapiException(ExceptionKeys.NEW_PASSWORD_IS_NULL);
		}
		if (changePasswordBean.getOldpassword() == null
				|| changePasswordBean.getOldpassword().equals("")) {
			throw new CapiException(ExceptionKeys.OLD_PASSWORD_IS_NULL);
		}
	}

	private AccountVO getAccoutVO(int accountID, DBAgentOO dbAgentOO)
			throws SQLException, Exception {
		AccountVO accountVO = new AccountVO();
		accountVO.setId(accountID);
		accountVO.setWhereId(true);
		accountVO = (AccountVO) dbAgentOO.select(accountVO);
		return accountVO;
	}

	public ChangePasswordResultBean changePassword(
			ChangePasswordBean changePasswordBean) throws Exception {
		ChangePasswordResultBean result = new ChangePasswordResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			changePasswordValidateNull(changePasswordBean);
			dbAgentOO.beginTransaction();
			Token token = RequestContext.getToken();
			AccountVO accountVO = getAccoutVO(token.getAccountid(), dbAgentOO);

			String oldPassword1 = accountVO.getPassword();
			if (!oldPassword1.equals(changePasswordBean.getOldpassword())) {
				result.setErrorCode(1);
				result.setEditStatus(false);
			} else {
				accountVO = new AccountVO();
				accountVO.setId(token.getAccountid());
				accountVO.setWhereId(true);
				accountVO.setPassword(changePasswordBean.getNewpassword());
				dbAgentOO.update(accountVO);
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
		}finally {
			dbAgentOO.releaseTransaction();
		}
		return result;
	}
}
