package com.carucrm.biz.carowner;

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
	private String password;
	
}
