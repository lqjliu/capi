package com.carucrm.biz.register;

import com.caru.biz.AuthenticationResultBean;

public class CorporationRegisterResultBean extends AuthenticationResultBean {
	private boolean regstatus = true;
	private int errorcode;
	public boolean isRegstatus() {
		return regstatus;
	}
	public void setRegstatus(boolean regstatus) {
		this.regstatus = regstatus;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public int getCorporationid() {
		return corporationid;
	}
	public void setCorporationid(int corporationid) {
		this.corporationid = corporationid;
	}
	private int corporationid;
}
