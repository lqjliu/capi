package com.carucrm.biz.carowner;


import java.util.Date;


public class ConsumeListBean {
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCorporationname() {
		return corporationname;
	}
	public void setCorporationname(String corporationname) {
		this.corporationname = corporationname;
	}
	public int getCorporationid() {
		return corporationid;
	}
	public void setCorporationid(int corporationid) {
		this.corporationid = corporationid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	private String corporationname;
	private int corporationid;
	private double money;
	private int consumeid;
	public int getConsumeid() {
		return consumeid;
	}
	public void setConsumeid(int consumeid) {
		this.consumeid = consumeid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	private int customerid;
	
	private String serviceitems;
	public String getServiceitems() {
		return serviceitems;
	}
	public void setServiceitems(String serviceitems) {
		this.serviceitems = serviceitems;
	}
	
	private int supportrepair;
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
	private int supportmaintain;
	private int supportwashing;
	private int supportdecorate;
	private int supportinsuranceconsult;
	private int supportnewcarregister;
	private int supportcrossplaceregister;
	private int support2handexchange;
}
