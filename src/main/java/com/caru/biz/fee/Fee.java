package com.caru.biz.fee;

import java.util.Date;

public class Fee {
	private long feeId;
	private double amount;
	private Date date;
	private int type;
	private String remarks;
	private long odometer;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public long getOdometer() {
		return odometer;
	}
	public void setOdometer(long odometer) {
		this.odometer = odometer;
	}
	public long getFeeId() {
		return feeId;
	}
	public void setFeeId(long feeId) {
		this.feeId = feeId;
	}
}
