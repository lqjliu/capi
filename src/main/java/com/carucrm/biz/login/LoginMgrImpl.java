package com.carucrm.biz.login;

import com.carucrm.vo.AccountVO;
import com.carucrm.vo.CorporationVO;
import com.common.db.DBAgentOO;
import com.common.exception.CapiException;
import com.common.exception.ExceptionKeys;
import com.common.web.Token;
import com.common.web.TokenUtil;

public class LoginMgrImpl {
	private static LoginMgrImpl instance = new LoginMgrImpl();

	public static LoginMgrImpl getInstance() {
		return instance;
	}

	private LoginMgrImpl() {
	}

	private void loginValidateNull(LoginBean loginBean) throws Exception {
		if (loginBean.getAccountname() == null
				|| loginBean.getAccountname().equals("")) {
			throw new CapiException(ExceptionKeys.ACCOUNTNAME_IS_NULL);
		}
		if (loginBean.getPassword() == null
				|| loginBean.getPassword().equals("")) {
			throw new CapiException(ExceptionKeys.PASSWORD_IS_NULL);
		}
		if (loginBean.getCorporationsymbol() == null
				|| loginBean.getCorporationsymbol().equals("")) {
			throw new CapiException(ExceptionKeys.SYMBOL_IS_NULL);
		}

	}

	public LoginResultBean loginCorporation(LoginBean loginBean)
			throws Exception {
		loginValidateNull(loginBean);
		LoginResultBean result = new LoginResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			CorporationVO corporationVO = new CorporationVO();
			corporationVO.setSymbol(loginBean.getCorporationsymbol());
			corporationVO.setWhereSymbol(true);
			corporationVO = (CorporationVO) dbAgentOO.select(corporationVO);
			if (corporationVO == null) {
				result.setErrorCode(1);
				result.setValidUser(false);
			} else {
				AccountVO accountVO = new AccountVO();
				accountVO.setName(loginBean.getAccountname());
				accountVO.setWhereName(true);
				accountVO.setCorporationid(corporationVO.getId());
				accountVO.setWhereCorporationid(true);
				accountVO = (AccountVO) dbAgentOO.select(accountVO);
				if (accountVO == null) {
					accountVO = new AccountVO();
					accountVO.setEmail(loginBean.getAccountname());
					accountVO.setWhereEmail(true);
					accountVO.setCorporationid(corporationVO.getId());
					accountVO.setWhereCorporationid(true);
					accountVO = (AccountVO) dbAgentOO.select(accountVO);
				}
				if (accountVO == null) {
					result.setErrorCode(2);
					result.setValidUser(false);
				} else {
					if (!accountVO.getPassword()
							.equals(loginBean.getPassword())) {
						result.setErrorCode(3);
						result.setValidUser(false);
					} else {
						result.setValidUser(true);
						Token token = new Token();
						token.setAccountid(accountVO.getId());
						token.setCorporationid(accountVO.getCorporationid());
						token.setContactid(accountVO.getContactid());
						String ticket = TokenUtil.getTicket(token);
						result.setCredential(ticket);
					}
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
		}finally {
			dbAgentOO.releaseTransaction();
		}
		return result;
	}

	public void logout(LogoutBean loginBean) throws Exception {
		TicketLib.getInstance().removeTicket(loginBean.getCredential());
	}

}
