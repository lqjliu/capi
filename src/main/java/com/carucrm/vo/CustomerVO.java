package com.carucrm.vo;

public class CustomerVO implements java.io.Serializable{
  public static final String TABLE_NAME = "customer";
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
  private boolean hasName;
  public boolean isHasName(){
    return hasName;
  }
  private boolean whereName;
  public boolean isWhereName(){
    return this.whereName;
  }
  public void setWhereName(boolean whereName){
    this.whereName = whereName;
  }
  private String name;
  public void setName(String name){
    this.hasName = true;
    this.name = name;
  }
  public String getName(){
    return name;
  }
  private boolean hasMobile;
  public boolean isHasMobile(){
    return hasMobile;
  }
  private boolean whereMobile;
  public boolean isWhereMobile(){
    return this.whereMobile;
  }
  public void setWhereMobile(boolean whereMobile){
    this.whereMobile = whereMobile;
  }
  private String mobile;
  public void setMobile(String mobile){
    this.hasMobile = true;
    this.mobile = mobile;
  }
  public String getMobile(){
    return mobile;
  }
  private boolean hasEmail;
  public boolean isHasEmail(){
    return hasEmail;
  }
  private boolean whereEmail;
  public boolean isWhereEmail(){
    return this.whereEmail;
  }
  public void setWhereEmail(boolean whereEmail){
    this.whereEmail = whereEmail;
  }
  private String email;
  public void setEmail(String email){
    this.hasEmail = true;
    this.email = email;
  }
  public String getEmail(){
    return email;
  }
  private boolean hasGender;
  public boolean isHasGender(){
    return hasGender;
  }
  private boolean whereGender;
  public boolean isWhereGender(){
    return this.whereGender;
  }
  public void setWhereGender(boolean whereGender){
    this.whereGender = whereGender;
  }
  private int gender;
  public void setGender(int gender){
    this.hasGender = true;
    this.gender = gender;
  }
  public int getGender(){
    return gender;
  }
  private boolean hasRemark;
  public boolean isHasRemark(){
    return hasRemark;
  }
  private boolean whereRemark;
  public boolean isWhereRemark(){
    return this.whereRemark;
  }
  public void setWhereRemark(boolean whereRemark){
    this.whereRemark = whereRemark;
  }
  private String remark;
  public void setRemark(String remark){
    this.hasRemark = true;
    this.remark = remark;
  }
  public String getRemark(){
    return remark;
  }
  private boolean hasCorporationid;
  public boolean isHasCorporationid(){
    return hasCorporationid;
  }
  private boolean whereCorporationid;
  public boolean isWhereCorporationid(){
    return this.whereCorporationid;
  }
  public void setWhereCorporationid(boolean whereCorporationid){
    this.whereCorporationid = whereCorporationid;
  }
  private int corporationid;
  public void setCorporationid(int corporationid){
    this.hasCorporationid = true;
    this.corporationid = corporationid;
  }
  public int getCorporationid(){
    return corporationid;
  }
  private boolean hasVerifycode;
  public boolean isHasVerifycode(){
    return hasVerifycode;
  }
  private boolean whereVerifycode;
  public boolean isWhereVerifycode(){
    return this.whereVerifycode;
  }
  public void setWhereVerifycode(boolean whereVerifycode){
    this.whereVerifycode = whereVerifycode;
  }
  private String verifycode;
  public void setVerifycode(String verifycode){
    this.hasVerifycode = true;
    this.verifycode = verifycode;
  }
  public String getVerifycode(){
    return verifycode;
  }
  private boolean hasVerified;
  public boolean isHasVerified(){
    return hasVerified;
  }
  private boolean whereVerified;
  public boolean isWhereVerified(){
    return this.whereVerified;
  }
  public void setWhereVerified(boolean whereVerified){
    this.whereVerified = whereVerified;
  }
  private int verified;
  public void setVerified(int verified){
    this.hasVerified = true;
    this.verified = verified;
  }
  public int getVerified(){
    return verified;
  }
  private boolean hasLatestconsumeid;
  public boolean isHasLatestconsumeid(){
    return hasLatestconsumeid;
  }
  private boolean whereLatestconsumeid;
  public boolean isWhereLatestconsumeid(){
    return this.whereLatestconsumeid;
  }
  public void setWhereLatestconsumeid(boolean whereLatestconsumeid){
    this.whereLatestconsumeid = whereLatestconsumeid;
  }
  private int latestconsumeid;
  public void setLatestconsumeid(int latestconsumeid){
    this.hasLatestconsumeid = true;
    this.latestconsumeid = latestconsumeid;
  }
  public int getLatestconsumeid(){
    return latestconsumeid;
  }
  private boolean hasLatestconsumedate;
  public boolean isHasLatestconsumedate(){
    return hasLatestconsumedate;
  }
  private boolean whereLatestconsumedate;
  public boolean isWhereLatestconsumedate(){
    return this.whereLatestconsumedate;
  }
  public void setWhereLatestconsumedate(boolean whereLatestconsumedate){
    this.whereLatestconsumedate = whereLatestconsumedate;
  }
  private java.util.Date latestconsumedate;
  public void setLatestconsumedate(java.util.Date latestconsumedate){
    this.hasLatestconsumedate = true;
    this.latestconsumedate = latestconsumedate;
  }
  public java.util.Date getLatestconsumedate(){
    return latestconsumedate;
  }
  private boolean hasLatestconsumemoney;
  public boolean isHasLatestconsumemoney(){
    return hasLatestconsumemoney;
  }
  private boolean whereLatestconsumemoney;
  public boolean isWhereLatestconsumemoney(){
    return this.whereLatestconsumemoney;
  }
  public void setWhereLatestconsumemoney(boolean whereLatestconsumemoney){
    this.whereLatestconsumemoney = whereLatestconsumemoney;
  }
  private double latestconsumemoney;
  public void setLatestconsumemoney(double latestconsumemoney){
    this.hasLatestconsumemoney = true;
    this.latestconsumemoney = latestconsumemoney;
  }
  public double getLatestconsumemoney(){
    return latestconsumemoney;
  }
  private boolean hasCumulatemoney;
  public boolean isHasCumulatemoney(){
    return hasCumulatemoney;
  }
  private boolean whereCumulatemoney;
  public boolean isWhereCumulatemoney(){
    return this.whereCumulatemoney;
  }
  public void setWhereCumulatemoney(boolean whereCumulatemoney){
    this.whereCumulatemoney = whereCumulatemoney;
  }
  private double cumulatemoney;
  public void setCumulatemoney(double cumulatemoney){
    this.hasCumulatemoney = true;
    this.cumulatemoney = cumulatemoney;
  }
  public double getCumulatemoney(){
    return cumulatemoney;
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
