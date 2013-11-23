package com.carucrm.biz.customer;

public class CustomerResultBean {
	private boolean cmdstatus = true;

	public boolean isCmdstatus() {
		return cmdstatus;
	}
	public void setCmdstatus(boolean cmdstatus) {
		this.cmdstatus = cmdstatus;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	private int errorcode;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

	private int customerid;

	public String toString(){
		return "cmdstatus = " + cmdstatus + " customerid = " + customerid 
		+ " errorcode = " + errorcode; 
	}
	
	  private String verifycode;

	public String getVerifycode() {
		return verifycode;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	} 
}
