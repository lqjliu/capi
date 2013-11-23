package com.carucrm.biz.consume;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerConsumeResultBean {
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private double summarymoney;
	public double getSummarymoney() {
		return summarymoney;
	}
	public void setSummarymoney(double summarymoney) {
		this.summarymoney = summarymoney;
	}
	private List customerconsume = new ArrayList();

	public List getCustomerconsume() {
		return customerconsume;
	}
	public void setCustomerconsume(List customerconsume) {
		this.customerconsume = customerconsume;
	}
	private int customerid;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomermobile() {
		return customermobile;
	}
	public void setCustomermobile(String customermobile) {
		this.customermobile = customermobile;
	}
	private String customername;
	private String customermobile;
}
