package com.caru.biz.user;

public class UserAccountEditResultBean {
	private int userId;
	private int carId;
	private boolean editStatus;
	private int errorCode;
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
	public boolean isEditStatus() {
		return editStatus;
	}
	public void setEditStatus(boolean editStatus) {
		this.editStatus = editStatus;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
