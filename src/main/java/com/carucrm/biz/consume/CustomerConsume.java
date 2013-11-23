package com.carucrm.biz.consume;

import java.util.Date;

public class CustomerConsume {
	private Date paiddate;

	public Date getPaiddate() {
		return paiddate;
	}

	public void setPaiddate(Date paiddate) {
		this.paiddate = paiddate;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getServiceitems() {
		return serviceitems;
	}

	public void setServiceitems(String serviceitems) {
		this.serviceitems = serviceitems;
	}

	public double getActualmoney() {
		return actualmoney;
	}

	public void setActualmoney(double actualmoney) {
		this.actualmoney = actualmoney;
	}

	public int getConsumeid() {
		return consumeid;
	}

	public void setConsumeid(int consumeid) {
		this.consumeid = consumeid;
	}

	private int customerid;
	private String platenumber;
	private String name;
	private String mobile;
	private String serviceitems;
	private double actualmoney;
	private int consumeid;

	private int supportrepair;
	public int getSupportrepair() {
		return supportrepair;
	}

	public void setSupportrepair(int supportrepair) {
		this.supportrepair = supportrepair;
	}

	private int supportmaintain;

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

	private int supportwashing;
	private int supportdecorate;
	private int supportinsuranceconsult;
	private int supportnewcarregister;
	private int supportcrossplaceregister;
	private int support2handexchange;

}
