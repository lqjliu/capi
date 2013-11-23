package com.carucrm.biz.account;

public class ChangePasswordResultBean {
	private boolean editStatus = true;
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
	private int errorCode;
}
