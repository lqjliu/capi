package com.carucrm.biz.register;

import java.util.Date;

public class CorporationRegisterBean {
	private String symbol;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		if(symbol != null){
			this.symbol = symbol.toLowerCase();
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSupportrepair() {
		return supportrepair;
	}
	public void setSupportrepair(int supportrepair) {
		this.supportrepair = supportrepair;
	}
	public int getSupportmaintain() {
		return supportmaintain;
	}
	public void setSupportmaintain(int supportmaintain) {
		this.supportmaintain = supportmaintain;
	}
	public int getSupportwashing() {
		return supportwashing;
	}
	public void setSupportwashing(int supportwashing) {
		this.supportwashing = supportwashing;
	}
	public int getSupportdecorate() {
		return supportdecorate;
	}
	public void setSupportdecorate(int supportdecorate) {
		this.supportdecorate = supportdecorate;
	}
	public int getSupportinsuranceconsult() {
		return supportinsuranceconsult;
	}
	public void setSupportinsuranceconsult(int supportinsuranceconsult) {
		this.supportinsuranceconsult = supportinsuranceconsult;
	}
	public int getSupportnewcarregister() {
		return supportnewcarregister;
	}
	public void setSupportnewcarregister(int supportnewcarregister) {
		this.supportnewcarregister = supportnewcarregister;
	}
	public int getSupportcrossplaceregister() {
		return supportcrossplaceregister;
	}
	public void setSupportcrossplaceregister(int supportcrossplaceregister) {
		this.supportcrossplaceregister = supportcrossplaceregister;
	}
	public int getSupport2handexchange() {
		return support2handexchange;
	}
	public void setSupport2handexchange(int support2handexchange) {
		this.support2handexchange = support2handexchange;
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public String getPlatenumberprefix() {
		return platenumberprefix;
	}
	public void setPlatenumberprefix(String platenumberprefix) {
		if(platenumberprefix != null){
			this.platenumberprefix = platenumberprefix.toUpperCase();
		}else{
			this.platenumberprefix = null;
		}
	}
	public String getCsphone2areacode() {
		return csphone2areacode;
	}
	public void setCsphone2areacode(String csphone2areacode) {
		this.csphone2areacode = csphone2areacode;
	}
	private String name;
	private int supportrepair;
	private int supportmaintain;
	private int supportwashing;
	private int supportdecorate;
	private int supportinsuranceconsult;
	private int supportnewcarregister;
	private int supportcrossplaceregister;
	private int support2handexchange;
	private int provinceid;
	private int cityid;
	private int countyid;
	public int getCountyid() {
		return countyid;
	}
	public void setCountyid(int countyid) {
		this.countyid = countyid;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getContactmobile() {
		return contactmobile;
	}
	public void setContactmobile(String contactmobile) {
		this.contactmobile = contactmobile;
	}
	public String getCsphone1areacode() {
		return csphone1areacode;
	}
	public void setCsphone1areacode(String csphone1areacode) {
		this.csphone1areacode = csphone1areacode;
	}
	public String getCsphone1() {
		return csphone1;
	}
	public void setCsphone1(String csphone1) {
		this.csphone1 = csphone1;
	}
	public String getCsphone2() {
		return csphone2;
	}
	public void setCsphone2(String csphone2) {
		this.csphone2 = csphone2;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		if(accountname != null){
			this.accountname = accountname.toLowerCase();
		}
	}
	public String getAccountemail() {
		return accountemail;
	}
	public void setAccountemail(String accountemail) {
		if(accountemail != null){
			this.accountemail = accountemail.toLowerCase();
		}
	}
	public String getAccountpassword() {
		return accountpassword;
	}
	public void setAccountpassword(String accountpassword) {
		this.accountpassword = accountpassword;
	}
	public String getAccountcontactname() {
		return accountcontactname;
	}
	public void setAccountcontactname(String accountcontactname) {
		this.accountcontactname = accountcontactname;
	}
	public String getAccountcontactmobile() {
		return accountcontactmobile;
	}
	public void setAccountcontactmobile(String accountcontactmobile) {
		this.accountcontactmobile = accountcontactmobile;
	}
	private String address;
	private String platenumberprefix;
	private String contactname;
	private String contactmobile;
	private String csphone1areacode;
	private String csphone1;
	private String csphone2areacode;
	private String csphone2;
	private String accountname;
	private String accountemail;
	private String accountpassword;
	private String accountcontactname;
	private String accountcontactmobile;
}
