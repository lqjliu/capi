package com.caru.biz.login;

import com.caru.db.DBAgentOO;
import com.caru.exception.CapiException;
import com.caru.exception.ExceptionKeys;
import com.caru.vo.CarVO;
import com.caru.vo.UserVO;

public class LoginMgrImpl {
	private static LoginMgrImpl instance = new LoginMgrImpl();

	public static LoginMgrImpl getInstance() {
		return instance;
	}

	private LoginMgrImpl() {
	}

	private void loginValidate(LoginBean loginBean) throws Exception{
		if(loginBean.getUserName() == null || loginBean.getUserName().equals("")){
			throw new CapiException(ExceptionKeys.USERNAME_IS_NULL);
		}
		if(loginBean.getPassword() == null || loginBean.getPassword().equals("")){
			throw new CapiException(ExceptionKeys.PASSWORD_IS_NULL);
		}
	}	
	public LoginResultBean login(LoginBean loginBean) throws Exception {
		LoginResultBean result = new LoginResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			UserVO userVO = new UserVO();
			userVO.setUsername(loginBean.getUserName());
			userVO.setWhereUsername(true);
			userVO = (UserVO) dbAgentOO.select(userVO);
			if (userVO == null) {
				result.setErrorCode(0);
				return result;
			} else {
				String password = userVO.getPassword();
				if (!password.equals(loginBean.getPassword())) {
					result.setErrorCode(1);
					return result;
				} else {
					String credential = Encryption.oneWayHash(loginBean.getUserName()
							+ loginBean.getPassword());
					credential = credential.substring(0, 20);
					result.setCredential(credential);
					result.setUserId(userVO.getUserid());
					result.setValidUser(true);
					CarVO carVO = new CarVO();
					carVO.setUserid(userVO.getUserid());
					carVO.setWhereUserid(true);
					carVO = (CarVO) dbAgentOO.select(carVO);
					result.setCarId(carVO.getCarid());
					Session session = new Session();
					session.setUId(userVO.getUserid());
					session.setCId(carVO.getCarid());
					TicketLib.getInstance().putTicket(credential,
							session);
				}
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		}
		return result;
	}
	
	public void logout(LogoutBean loginBean) throws Exception {
		TicketLib.getInstance().removeTicket(loginBean.getCredential());
	}
	
	public Session getSession(String credential) {
		Session session = TicketLib.getInstance().getTicket(credential);
		return session;
	}

}
