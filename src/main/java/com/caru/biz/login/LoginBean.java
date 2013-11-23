package com.caru.biz.login;

public class LoginBean {
	private String userName;
	private String password;
	private boolean rememberMe;
	private String loginFromIP;
	private String loginOS;
	private String loginBrowser;
	private String loginRefFrom;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	public String getLoginFromIP() {
		return loginFromIP;
	}
	public void setLoginFromIP(String loginFromIP) {
		this.loginFromIP = loginFromIP;
	}
	public String getLoginOS() {
		return loginOS;
	}
	public void setLoginOS(String loginOS) {
		this.loginOS = loginOS;
	}
	public String getLoginBrowser() {
		return loginBrowser;
	}
	public void setLoginBrowser(String loginBrowser) {
		this.loginBrowser = loginBrowser;
	}
	public String getLoginRefFrom() {
		return loginRefFrom;
	}
	public void setLoginRefFrom(String loginRefFrom) {
		this.loginRefFrom = loginRefFrom;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
