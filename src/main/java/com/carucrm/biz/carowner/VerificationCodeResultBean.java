package com.carucrm.biz.carowner;

import java.util.Date;

import com.carucrm.biz.ResultBean;

public class VerificationCodeResultBean extends ResultBean {
	private int corporationid;
	public int getCorporationid() {
		return corporationid;
	}
	public void setCorporationid(int corporationid) {
		this.corporationid = corporationid;
	}
	private String corporationname;
	public String getCorporationname() {
		return corporationname;
	}
	public void setCorporationname(String corporationname) {
		this.corporationname = corporationname;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	private int provinceid;
	private int cityid;
	private int vendorid;
	private int brandid;
	private int modelid;
	private Date registrydate;
	private int customerid;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
}
