package com.carucrm.biz;

public class UpdateResultBean {
	private boolean updateStatus = true;

	public boolean isUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(boolean updateStatus) {
		this.updateStatus = updateStatus;
	}
	private int errorcode;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
}
