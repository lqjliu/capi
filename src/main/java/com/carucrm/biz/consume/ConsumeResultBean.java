package com.carucrm.biz.consume;

public class ConsumeResultBean {
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

	private int consumeid;

	public int getConsumeid() {
		return consumeid;
	}

	public void setConsumeid(int consumeid) {
		this.consumeid = consumeid;
	}

	public String toString() {
		return "cmdstatus = " + cmdstatus + " customerid = " + consumeid
				+ " errorcode = " + errorcode;
	}
}
