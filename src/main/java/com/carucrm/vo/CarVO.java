package com.carucrm.vo;

public class CarVO implements java.io.Serializable{
  public static final String TABLE_NAME = "car";
  private boolean hasId;
  public boolean isHasId(){
    return hasId;
  }
  private boolean whereId;
  public boolean isWhereId(){
    return this.whereId;
  }
  public void setWhereId(boolean whereId){
    this.whereId = whereId;
  }
  private int id;
  public void setId(int id){
    this.hasId = true;
    this.id = id;
  }
  public int getId(){
    return id;
  }
  private boolean hasPlatenumber;
  public boolean isHasPlatenumber(){
    return hasPlatenumber;
  }
  private boolean wherePlatenumber;
  public boolean isWherePlatenumber(){
    return this.wherePlatenumber;
  }
  public void setWherePlatenumber(boolean wherePlatenumber){
    this.wherePlatenumber = wherePlatenumber;
  }
  private String platenumber;
  public void setPlatenumber(String platenumber){
    this.hasPlatenumber = true;
    this.platenumber = platenumber;
  }
  public String getPlatenumber(){
    return platenumber;
  }
  private boolean hasProvinceid;
  public boolean isHasProvinceid(){
    return hasProvinceid;
  }
  private boolean whereProvinceid;
  public boolean isWhereProvinceid(){
    return this.whereProvinceid;
  }
  public void setWhereProvinceid(boolean whereProvinceid){
    this.whereProvinceid = whereProvinceid;
  }
  private int provinceid;
  public void setProvinceid(int provinceid){
    this.hasProvinceid = true;
    this.provinceid = provinceid;
  }
  public int getProvinceid(){
    return provinceid;
  }
  private boolean hasCityid;
  public boolean isHasCityid(){
    return hasCityid;
  }
  private boolean whereCityid;
  public boolean isWhereCityid(){
    return this.whereCityid;
  }
  public void setWhereCityid(boolean whereCityid){
    this.whereCityid = whereCityid;
  }
  private int cityid;
  public void setCityid(int cityid){
    this.hasCityid = true;
    this.cityid = cityid;
  }
  public int getCityid(){
    return cityid;
  }
  private boolean hasVendorid;
  public boolean isHasVendorid(){
    return hasVendorid;
  }
  private boolean whereVendorid;
  public boolean isWhereVendorid(){
    return this.whereVendorid;
  }
  public void setWhereVendorid(boolean whereVendorid){
    this.whereVendorid = whereVendorid;
  }
  private int vendorid;
  public void setVendorid(int vendorid){
    this.hasVendorid = true;
    this.vendorid = vendorid;
  }
  public int getVendorid(){
    return vendorid;
  }
  private boolean hasBrandid;
  public boolean isHasBrandid(){
    return hasBrandid;
  }
  private boolean whereBrandid;
  public boolean isWhereBrandid(){
    return this.whereBrandid;
  }
  public void setWhereBrandid(boolean whereBrandid){
    this.whereBrandid = whereBrandid;
  }
  private int brandid;
  public void setBrandid(int brandid){
    this.hasBrandid = true;
    this.brandid = brandid;
  }
  public int getBrandid(){
    return brandid;
  }
  private boolean hasModelid;
  public boolean isHasModelid(){
    return hasModelid;
  }
  private boolean whereModelid;
  public boolean isWhereModelid(){
    return this.whereModelid;
  }
  public void setWhereModelid(boolean whereModelid){
    this.whereModelid = whereModelid;
  }
  private int modelid;
  public void setModelid(int modelid){
    this.hasModelid = true;
    this.modelid = modelid;
  }
  public int getModelid(){
    return modelid;
  }
  private boolean hasRegistrydate;
  public boolean isHasRegistrydate(){
    return hasRegistrydate;
  }
  private boolean whereRegistrydate;
  public boolean isWhereRegistrydate(){
    return this.whereRegistrydate;
  }
  public void setWhereRegistrydate(boolean whereRegistrydate){
    this.whereRegistrydate = whereRegistrydate;
  }
  private java.util.Date registrydate;
  public void setRegistrydate(java.util.Date registrydate){
    this.hasRegistrydate = true;
    this.registrydate = registrydate;
  }
  public java.util.Date getRegistrydate(){
    return registrydate;
  }
  private boolean hasAccountid;
  public boolean isHasAccountid(){
    return hasAccountid;
  }
  private boolean whereAccountid;
  public boolean isWhereAccountid(){
    return this.whereAccountid;
  }
  public void setWhereAccountid(boolean whereAccountid){
    this.whereAccountid = whereAccountid;
  }
  private int accountid;
  public void setAccountid(int accountid){
    this.hasAccountid = true;
    this.accountid = accountid;
  }
  public int getAccountid(){
    return accountid;
  }
  private boolean hasActive;
  public boolean isHasActive(){
    return hasActive;
  }
  private boolean whereActive;
  public boolean isWhereActive(){
    return this.whereActive;
  }
  public void setWhereActive(boolean whereActive){
    this.whereActive = whereActive;
  }
  private int active;
  public void setActive(int active){
    this.hasActive = true;
    this.active = active;
  }
  public int getActive(){
    return active;
  }
  private boolean hasCreatedtime;
  public boolean isHasCreatedtime(){
    return hasCreatedtime;
  }
  private boolean whereCreatedtime;
  public boolean isWhereCreatedtime(){
    return this.whereCreatedtime;
  }
  public void setWhereCreatedtime(boolean whereCreatedtime){
    this.whereCreatedtime = whereCreatedtime;
  }
  private java.util.Date createdtime;
  public void setCreatedtime(java.util.Date createdtime){
    this.hasCreatedtime = true;
    this.createdtime = createdtime;
  }
  public java.util.Date getCreatedtime(){
    return createdtime;
  }
  private boolean hasLastmodifiedtime;
  public boolean isHasLastmodifiedtime(){
    return hasLastmodifiedtime;
  }
  private boolean whereLastmodifiedtime;
  public boolean isWhereLastmodifiedtime(){
    return this.whereLastmodifiedtime;
  }
  public void setWhereLastmodifiedtime(boolean whereLastmodifiedtime){
    this.whereLastmodifiedtime = whereLastmodifiedtime;
  }
  private java.util.Date lastmodifiedtime;
  public void setLastmodifiedtime(java.util.Date lastmodifiedtime){
    this.hasLastmodifiedtime = true;
    this.lastmodifiedtime = lastmodifiedtime;
  }
  public java.util.Date getLastmodifiedtime(){
    return lastmodifiedtime;
  }
}
