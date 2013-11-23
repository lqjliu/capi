package com.caru.biz.login;

import com.caru.biz.AuthenticationResultBean;

public class LoginResultBean extends AuthenticationResultBean{ 
	private boolean validUser;
	private int errorCode;
	private int feeInputMode;
	private int uRLAfterLogin;
	private int userId;
	private int carId;
	public boolean isValidUser() {
		return validUser;
	}
	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public int getFeeInputMode() {
		return feeInputMode;
	}
	public void setFeeInputMode(int feeInputMode) {
		this.feeInputMode = feeInputMode;
	}
	public int getURLAfterLogin() {
		return uRLAfterLogin;
	}
	public void setURLAfterLogin(int afterLogin) {
		uRLAfterLogin = afterLogin;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}

}
