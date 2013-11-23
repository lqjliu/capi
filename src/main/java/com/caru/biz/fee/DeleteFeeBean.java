package com.caru.biz.fee;

import java.util.List;

public class DeleteFeeBean {
	private long userId;
	private long carId;
	private List feeIds;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public List getFeeIds() {
		return feeIds;
	}
	public void setFeeIds(List feeIds) {
		this.feeIds = feeIds;
	}
}
