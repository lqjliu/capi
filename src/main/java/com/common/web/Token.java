package com.common.web;

public class Token {
	private int accountid;

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public int getCorporationid() {
		return corporationid;
	}

	public void setCorporationid(int corporationid) {
		this.corporationid = corporationid;
	}

	public int getContactid() {
		return contactid;
	}

	public void setContactid(int contactid) {
		this.contactid = contactid;
	}

	private int corporationid;
	private int contactid;
	private int[] carids = new int[0];

	public int[] getCarids() {
		return carids;
	}

	public void setCarids(int[] carids) {
		this.carids = carids;
	}

	private long activeTime = System.currentTimeMillis();

	public long getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(long activeTime) {
		this.activeTime = activeTime;
	}

	public String toString() {
		String result = "accountid = " + accountid + " corporationid = "
				+ corporationid + " contactid = " + contactid;
		String carS = "";
		if (carids != null) {
			for (int i = 0; i < carids.length; i++) {
				carS = carS + (" carid[" + i + "] = " + carids[i]);
			}
		}
		result = result + carS;
		result = result + " ActiveTime = " + activeTime;
		return result;
	}
}
