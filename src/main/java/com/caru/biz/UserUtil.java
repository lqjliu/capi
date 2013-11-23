package com.caru.biz;

import com.caru.db.DBAgentOO;
import com.caru.vo.UserVO;

public class UserUtil {
	public static boolean isEmailExist(String email) {
		return isEmailExist(0, email);
	}
	public static boolean isEmailExist(long uId, String email) {
		boolean result = false;
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			UserVO userVO = new UserVO();
			userVO.setEmail(email);
			userVO.setWhereEmail(true);
			userVO = (UserVO) dbAgentOO.select(userVO);
			if (uId == 0) {
				if (userVO != null) {
					result = true;
				}
			} else {
				if (userVO != null && userVO.getUserid() != uId) {
					result = true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}
		return result;
	}

	public static boolean isUsernameExist(String username){
		return isUsernameExist(0, username);
	}
	
	public static boolean isUsernameExist(long uId, String username) {
		boolean result = false;
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			UserVO userVO = new UserVO();
			userVO.setUsername(username);
			userVO.setWhereUsername(true);
			userVO = (UserVO) dbAgentOO.select(userVO);
			if (uId == 0) {
				if (userVO != null) {
					result = true;
				}
			} else {
				if (userVO != null && userVO.getUserid() != uId) {
					result = true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}
		return result;
	}
}
