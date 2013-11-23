package com.carucrm.biz.login;

public class LoginBean {
	private String accountname;

	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		if(accountname != null){
			this.accountname = accountname.toLowerCase();
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorporationsymbol() {
		return corporationsymbol;
	}
	public void setCorporationsymbol(String corporationsymbol) {
		if(corporationsymbol != null){
			this.corporationsymbol = corporationsymbol.toLowerCase();
		}
	}
	private String password;
	private String corporationsymbol;

}
