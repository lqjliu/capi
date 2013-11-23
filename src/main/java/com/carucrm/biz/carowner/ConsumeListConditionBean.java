package com.carucrm.biz.carowner;

import java.util.Date;

public class ConsumeListConditionBean {
	private int corporationid;
	public int getCorporationid() {
		return corporationid;
	}
	public void setCorporationid(int corporationid) {
		this.corporationid = corporationid;
	}
	private Date startdate;
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public double getStartmoney() {
		return startmoney;
	}
	public void setStartmoney(double startmoney) {
		this.startmoney = startmoney;
	}
	public double getEndmoney() {
		return endmoney;
	}
	public void setEndmoney(double endmoney) {
		this.endmoney = endmoney;
	}
	private Date enddate;
	private double startmoney;
	private double endmoney;
	private int supportrepair = 1;
	private int supportmaintain = 1;
	private int supportwashing = 1;
	private int supportdecorate = 1;
	private int supportinsuranceconsult = 1;
	private int supportnewcarregister = 1;
	private int supportcrossplaceregister = 1;
	private int support2handexchange = 1;
	private int listway;
	public int getListway() {
		return listway;
	}
	public void setListway(int listway) {
		this.listway = listway;
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
	private int currentpageno = 1;
	public int getCurrentpageno() {
		return currentpageno;
	}
	public void setCurrentpageno(int currentpageno) {
		this.currentpageno = currentpageno;
	}

	private String orderby;
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	public int getOrderway() {
		return orderway;
	}
	public void setOrderway(int orderway) {
		this.orderway = orderway;
	}
	private int orderway;

}
