package com.caru.biz.register;

import java.util.Date;

public class UserRegisterBean {
	private String email;
	private String userName;
	private String password;
	private int purchasedTag;
	private int venderId;
	private int brandId;
	private int modelId;
	private String modelDIYname;
	private int dIYTankVolume;
	private int provinceId;
	private int cityId;
	private boolean acceptSiteRule;
	private int purchasedType;
	private Date purchasedDate;
	private double totalPrice;
	private String picURL;
	private String nickName;
	private String registerIP;
	private String registerRefFrom;
	private int userID;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPurchasedTag() {
		return purchasedTag;
	}
	public void setPurchasedTag(int purchasedTag) {
		this.purchasedTag = purchasedTag;
	}
	public int getVenderId() {
		return venderId;
	}
	public void setVenderId(int venderId) {
		this.venderId = venderId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public String getModelDIYname() {
		return modelDIYname;
	}
	public void setModelDIYname(String modelDIYname) {
		this.modelDIYname = modelDIYname;
	}
	public int getDIYTankVolume() {
		return dIYTankVolume;
	}
	public void setDIYTankVolume(int tankVolume) {
		dIYTankVolume = tankVolume;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public boolean isAcceptSiteRule() {
		return acceptSiteRule;
	}
	public void setAcceptSiteRule(boolean acceptSiteRule) {
		this.acceptSiteRule = acceptSiteRule;
	}
	public int getPurchasedType() {
		return purchasedType;
	}
	public void setPurchasedType(int purchasedType) {
		this.purchasedType = purchasedType;
	}
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPicURL() {
		return picURL;
	}
	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}
	public String getRegisterIP() {
		return registerIP;
	}
	public void setRegisterIP(String registerIP) {
		this.registerIP = registerIP;
	}
	public String getRegisterRefFrom() {
		return registerRefFrom;
	}
	public void setRegisterRefFrom(String registerRefFrom) {
		this.registerRefFrom = registerRefFrom;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
