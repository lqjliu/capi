package com.carucrm.biz;

public class ResultBean {
	private boolean cmdstatus = true;
	public boolean isCmdstatus() {
		return cmdstatus;
	}
	public void setCmdstatus(boolean cmdstatus) {
		this.cmdstatus = cmdstatus;
	}
	private int errorcode;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

}
