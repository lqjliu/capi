package com.caru.biz.register;

import com.caru.biz.AuthenticationResultBean;

public class UserRegisterResultBean extends AuthenticationResultBean {
	private boolean regStatus = true;
	private int errorCode;
	private int userId;
	private int carId;
	public boolean isRegStatus() {
		return regStatus;
	}
	public void setRegStatus(boolean regStatus) {
		this.regStatus = regStatus;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
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
