package com.carucrm.biz.customer;

public class LatestCustomerInputBean {
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