package com.caru.biz.fee;

import java.util.Date;

public class AddFeeBean {
	private long carId;
	private long userId;
	private Fee fee = new Fee();
	
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public double getAmount() {
		return fee.getAmount();
	}
	public void setAmount(double amount) {
		fee.setAmount(amount);
	}
	public Date getDate() {
		return fee.getDate();
	}
	public void setDate(Date date) {
		fee.setDate(date);
	}
	public int getType() {
		return fee.getType();
	}
	public void setType(int type) {
		fee.setType(type);
	}
	public String getRemarks() {
		return fee.getRemarks();
	}
	public void setRemarks(String remarks) {
		fee.setRemarks(remarks);
	}
	public long getOdometer() {
		return fee.getOdometer();
	}
	public void setOdometer(long odometer) {
		fee.setOdometer(odometer);
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Fee getFee() {
		return fee;
	}
}
