package com.caru.biz.fee;

import java.util.List;

public class BatchEditFeeBean {
	private long carId;
	private long userId;
	private List feeList;
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List getFeeList() {
		return feeList;
	}
	public void setFeeList(List feeList) {
		this.feeList = feeList;
	}
}
