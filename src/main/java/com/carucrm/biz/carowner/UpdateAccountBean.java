package com.carucrm.biz.carowner;

import java.util.Date;

public class UpdateAccountBean {
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email != null){
			this.email = email.toLowerCase();
		}else{
			this.email = null;
		}
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public int getBrandid() {
		return brandid;
	}
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}
	public int getModelid() {
		return modelid;
	}
	public void setModelid(int modelid) {
		this.modelid = modelid;
	}
	public Date getRegistrydate() {
		return registrydate;
	}
	public void setRegistrydate(Date registrydate) {
		this.registrydate = registrydate;
	}
	private String email;
	
	private int provinceid;
	private int cityid;
	private int vendorid;
	private int brandid;
	private int modelid;
	private Date registrydate;
}
