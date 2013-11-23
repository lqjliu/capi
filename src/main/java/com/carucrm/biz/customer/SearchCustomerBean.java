package com.carucrm.biz.customer;

import java.util.Date;

public class SearchCustomerBean {
	private int customerid;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	private String name;
	private String platenumber;
	private String mobile;
	private double cumulatemoney;
	private Date latestconsumedate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlatenumber() {
		return platenumber;
	}
	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public double getCumulatemoney() {
		return cumulatemoney;
	}
	public void setCumulatemoney(double cumulatemoney) {
		this.cumulatemoney = cumulatemoney;
	}
	public Date getLatestconsumedate() {
		return latestconsumedate;
	}
	public void setLatestconsumedate(Date latestconsumedate) {
		this.latestconsumedate = latestconsumedate;
	}
	public double getLatestconsumemoney() {
		return latestconsumemoney;
	}
	public void setLatestconsumemoney(double latestconsumemoney) {
		this.latestconsumemoney = latestconsumemoney;
	}
	private double latestconsumemoney;
}
