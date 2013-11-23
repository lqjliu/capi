package com.caru.vo;

public class FeeVO implements java.io.Serializable{
  public static final String TABLE_NAME = "fee";
  private boolean hasUserid;
  public boolean isHasUserid(){
    return hasUserid;
  }
  private boolean whereUserid;
  public boolean isWhereUserid(){
    return this.whereUserid;
  }
  public void setWhereUserid(boolean whereUserid){
    this.whereUserid = whereUserid;
  }
  private int userid;
  public void setUserid(int userid){
    this.hasUserid = true;
    this.userid = userid;
  }
  public int getUserid(){
    return userid;
  }
  private boolean hasCarid;
  public boolean isHasCarid(){
    return hasCarid;
  }
  private boolean whereCarid;
  public boolean isWhereCarid(){
    return this.whereCarid;
  }
  public void setWhereCarid(boolean whereCarid){
    this.whereCarid = whereCarid;
  }
  private int carid;
  public void setCarid(int carid){
    this.hasCarid = true;
    this.carid = carid;
  }
  public int getCarid(){
    return carid;
  }
  private boolean hasFeeid;
  public boolean isHasFeeid(){
    return hasFeeid;
  }
  private boolean whereFeeid;
  public boolean isWhereFeeid(){
    return this.whereFeeid;
  }
  public void setWhereFeeid(boolean whereFeeid){
    this.whereFeeid = whereFeeid;
  }
  private int feeid;
  public void setFeeid(int feeid){
    this.hasFeeid = true;
    this.feeid = feeid;
  }
  public int getFeeid(){
    return feeid;
  }
  private boolean hasType;
  public boolean isHasType(){
    return hasType;
  }
  private boolean whereType;
  public boolean isWhereType(){
    return this.whereType;
  }
  public void setWhereType(boolean whereType){
    this.whereType = whereType;
  }
  private int type;
  public void setType(int type){
    this.hasType = true;
    this.type = type;
  }
  public int getType(){
    return type;
  }
  private boolean hasSubtype;
  public boolean isHasSubtype(){
    return hasSubtype;
  }
  private boolean whereSubtype;
  public boolean isWhereSubtype(){
    return this.whereSubtype;
  }
  public void setWhereSubtype(boolean whereSubtype){
    this.whereSubtype = whereSubtype;
  }
  private int subtype;
  public void setSubtype(int subtype){
    this.hasSubtype = true;
    this.subtype = subtype;
  }
  public int getSubtype(){
    return subtype;
  }
  private boolean hasAmount;
  public boolean isHasAmount(){
    return hasAmount;
  }
  private boolean whereAmount;
  public boolean isWhereAmount(){
    return this.whereAmount;
  }
  public void setWhereAmount(boolean whereAmount){
    this.whereAmount = whereAmount;
  }
  private double amount;
  public void setAmount(double amount){
    this.hasAmount = true;
    this.amount = amount;
  }
  public double getAmount(){
    return amount;
  }
  private boolean hasDate;
  public boolean isHasDate(){
    return hasDate;
  }
  private boolean whereDate;
  public boolean isWhereDate(){
    return this.whereDate;
  }
  public void setWhereDate(boolean whereDate){
    this.whereDate = whereDate;
  }
  private java.util.Date date;
  public void setDate(java.util.Date date){
    this.hasDate = true;
    this.date = date;
  }
  public java.util.Date getDate(){
    return date;
  }
  private boolean hasPicurl;
  public boolean isHasPicurl(){
    return hasPicurl;
  }
  private boolean wherePicurl;
  public boolean isWherePicurl(){
    return this.wherePicurl;
  }
  public void setWherePicurl(boolean wherePicurl){
    this.wherePicurl = wherePicurl;
  }
  private String picurl;
  public void setPicurl(String picurl){
    this.hasPicurl = true;
    this.picurl = picurl;
  }
  public String getPicurl(){
    return picurl;
  }
  private boolean hasOdometer;
  public boolean isHasOdometer(){
    return hasOdometer;
  }
  private boolean whereOdometer;
  public boolean isWhereOdometer(){
    return this.whereOdometer;
  }
  public void setWhereOdometer(boolean whereOdometer){
    this.whereOdometer = whereOdometer;
  }
  private int odometer;
  public void setOdometer(int odometer){
    this.hasOdometer = true;
    this.odometer = odometer;
  }
  public int getOdometer(){
    return odometer;
  }
  private boolean hasQuantity;
  public boolean isHasQuantity(){
    return hasQuantity;
  }
  private boolean whereQuantity;
  public boolean isWhereQuantity(){
    return this.whereQuantity;
  }
  public void setWhereQuantity(boolean whereQuantity){
    this.whereQuantity = whereQuantity;
  }
  private int quantity;
  public void setQuantity(int quantity){
    this.hasQuantity = true;
    this.quantity = quantity;
  }
  public int getQuantity(){
    return quantity;
  }
  private boolean hasPrice;
  public boolean isHasPrice(){
    return hasPrice;
  }
  private boolean wherePrice;
  public boolean isWherePrice(){
    return this.wherePrice;
  }
  public void setWherePrice(boolean wherePrice){
    this.wherePrice = wherePrice;
  }
  private double price;
  public void setPrice(double price){
    this.hasPrice = true;
    this.price = price;
  }
  public double getPrice(){
    return price;
  }
  private boolean hasTelephone;
  public boolean isHasTelephone(){
    return hasTelephone;
  }
  private boolean whereTelephone;
  public boolean isWhereTelephone(){
    return this.whereTelephone;
  }
  public void setWhereTelephone(boolean whereTelephone){
    this.whereTelephone = whereTelephone;
  }
  private String telephone;
  public void setTelephone(String telephone){
    this.hasTelephone = true;
    this.telephone = telephone;
  }
  public String getTelephone(){
    return telephone;
  }
  private boolean hasRemarks;
  public boolean isHasRemarks(){
    return hasRemarks;
  }
  private boolean whereRemarks;
  public boolean isWhereRemarks(){
    return this.whereRemarks;
  }
  public void setWhereRemarks(boolean whereRemarks){
    this.whereRemarks = whereRemarks;
  }
  private String remarks;
  public void setRemarks(String remarks){
    this.hasRemarks = true;
    this.remarks = remarks;
  }
  public String getRemarks(){
    return remarks;
  }
  private boolean hasStartcity;
  public boolean isHasStartcity(){
    return hasStartcity;
  }
  private boolean whereStartcity;
  public boolean isWhereStartcity(){
    return this.whereStartcity;
  }
  public void setWhereStartcity(boolean whereStartcity){
    this.whereStartcity = whereStartcity;
  }
  private String startcity;
  public void setStartcity(String startcity){
    this.hasStartcity = true;
    this.startcity = startcity;
  }
  public String getStartcity(){
    return startcity;
  }
  private boolean hasStartplace;
  public boolean isHasStartplace(){
    return hasStartplace;
  }
  private boolean whereStartplace;
  public boolean isWhereStartplace(){
    return this.whereStartplace;
  }
  public void setWhereStartplace(boolean whereStartplace){
    this.whereStartplace = whereStartplace;
  }
  private String startplace;
  public void setStartplace(String startplace){
    this.hasStartplace = true;
    this.startplace = startplace;
  }
  public String getStartplace(){
    return startplace;
  }
  private boolean hasTargetcity;
  public boolean isHasTargetcity(){
    return hasTargetcity;
  }
  private boolean whereTargetcity;
  public boolean isWhereTargetcity(){
    return this.whereTargetcity;
  }
  public void setWhereTargetcity(boolean whereTargetcity){
    this.whereTargetcity = whereTargetcity;
  }
  private String targetcity;
  public void setTargetcity(String targetcity){
    this.hasTargetcity = true;
    this.targetcity = targetcity;
  }
  public String getTargetcity(){
    return targetcity;
  }
  private boolean hasTargetplace;
  public boolean isHasTargetplace(){
    return hasTargetplace;
  }
  private boolean whereTargetplace;
  public boolean isWhereTargetplace(){
    return this.whereTargetplace;
  }
  public void setWhereTargetplace(boolean whereTargetplace){
    this.whereTargetplace = whereTargetplace;
  }
  private String targetplace;
  public void setTargetplace(String targetplace){
    this.hasTargetplace = true;
    this.targetplace = targetplace;
  }
  public String getTargetplace(){
    return targetplace;
  }
  private boolean hasPassedcitys;
  public boolean isHasPassedcitys(){
    return hasPassedcitys;
  }
  private boolean wherePassedcitys;
  public boolean isWherePassedcitys(){
    return this.wherePassedcitys;
  }
  public void setWherePassedcitys(boolean wherePassedcitys){
    this.wherePassedcitys = wherePassedcitys;
  }
  private String passedcitys;
  public void setPassedcitys(String passedcitys){
    this.hasPassedcitys = true;
    this.passedcitys = passedcitys;
  }
  public String getPassedcitys(){
    return passedcitys;
  }
  private boolean hasBylines;
  public boolean isHasBylines(){
    return hasBylines;
  }
  private boolean whereBylines;
  public boolean isWhereBylines(){
    return this.whereBylines;
  }
  public void setWhereBylines(boolean whereBylines){
    this.whereBylines = whereBylines;
  }
  private String bylines;
  public void setBylines(String bylines){
    this.hasBylines = true;
    this.bylines = bylines;
  }
  public String getBylines(){
    return bylines;
  }
  private boolean hasKilometer;
  public boolean isHasKilometer(){
    return hasKilometer;
  }
  private boolean whereKilometer;
  public boolean isWhereKilometer(){
    return this.whereKilometer;
  }
  public void setWhereKilometer(boolean whereKilometer){
    this.whereKilometer = whereKilometer;
  }
  private int kilometer;
  public void setKilometer(int kilometer){
    this.hasKilometer = true;
    this.kilometer = kilometer;
  }
  public int getKilometer(){
    return kilometer;
  }
  private boolean hasOdometer1;
  public boolean isHasOdometer1(){
    return hasOdometer1;
  }
  private boolean whereOdometer1;
  public boolean isWhereOdometer1(){
    return this.whereOdometer1;
  }
  public void setWhereOdometer1(boolean whereOdometer1){
    this.whereOdometer1 = whereOdometer1;
  }
  private int odometer1;
  public void setOdometer1(int odometer1){
    this.hasOdometer1 = true;
    this.odometer1 = odometer1;
  }
  public int getOdometer1(){
    return odometer1;
  }
  private boolean hasPlacename;
  public boolean isHasPlacename(){
    return hasPlacename;
  }
  private boolean wherePlacename;
  public boolean isWherePlacename(){
    return this.wherePlacename;
  }
  public void setWherePlacename(boolean wherePlacename){
    this.wherePlacename = wherePlacename;
  }
  private String placename;
  public void setPlacename(String placename){
    this.hasPlacename = true;
    this.placename = placename;
  }
  public String getPlacename(){
    return placename;
  }
  private boolean hasAddress;
  public boolean isHasAddress(){
    return hasAddress;
  }
  private boolean whereAddress;
  public boolean isWhereAddress(){
    return this.whereAddress;
  }
  public void setWhereAddress(boolean whereAddress){
    this.whereAddress = whereAddress;
  }
  private String address;
  public void setAddress(String address){
    this.hasAddress = true;
    this.address = address;
  }
  public String getAddress(){
    return address;
  }
  private boolean hasStophours;
  public boolean isHasStophours(){
    return hasStophours;
  }
  private boolean whereStophours;
  public boolean isWhereStophours(){
    return this.whereStophours;
  }
  public void setWhereStophours(boolean whereStophours){
    this.whereStophours = whereStophours;
  }
  private int stophours;
  public void setStophours(int stophours){
    this.hasStophours = true;
    this.stophours = stophours;
  }
  public int getStophours(){
    return stophours;
  }
  private boolean hasStopcity;
  public boolean isHasStopcity(){
    return hasStopcity;
  }
  private boolean whereStopcity;
  public boolean isWhereStopcity(){
    return this.whereStopcity;
  }
  public void setWhereStopcity(boolean whereStopcity){
    this.whereStopcity = whereStopcity;
  }
  private String stopcity;
  public void setStopcity(String stopcity){
    this.hasStopcity = true;
    this.stopcity = stopcity;
  }
  public String getStopcity(){
    return stopcity;
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
  private boolean hasContact;
  public boolean isHasContact(){
    return hasContact;
  }
  private boolean whereContact;
  public boolean isWhereContact(){
    return this.whereContact;
  }
  public void setWhereContact(boolean whereContact){
    this.whereContact = whereContact;
  }
  private String contact;
  public void setContact(String contact){
    this.hasContact = true;
    this.contact = contact;
  }
  public String getContact(){
    return contact;
  }
  private boolean hasEffecteddate;
  public boolean isHasEffecteddate(){
    return hasEffecteddate;
  }
  private boolean whereEffecteddate;
  public boolean isWhereEffecteddate(){
    return this.whereEffecteddate;
  }
  public void setWhereEffecteddate(boolean whereEffecteddate){
    this.whereEffecteddate = whereEffecteddate;
  }
  private java.util.Date effecteddate;
  public void setEffecteddate(java.util.Date effecteddate){
    this.hasEffecteddate = true;
    this.effecteddate = effecteddate;
  }
  public java.util.Date getEffecteddate(){
    return effecteddate;
  }
  private boolean hasDuration;
  public boolean isHasDuration(){
    return hasDuration;
  }
  private boolean whereDuration;
  public boolean isWhereDuration(){
    return this.whereDuration;
  }
  public void setWhereDuration(boolean whereDuration){
    this.whereDuration = whereDuration;
  }
  private int duration;
  public void setDuration(int duration){
    this.hasDuration = true;
    this.duration = duration;
  }
  public int getDuration(){
    return duration;
  }
  private boolean hasItemnnme;
  public boolean isHasItemnnme(){
    return hasItemnnme;
  }
  private boolean whereItemnnme;
  public boolean isWhereItemnnme(){
    return this.whereItemnnme;
  }
  public void setWhereItemnnme(boolean whereItemnnme){
    this.whereItemnnme = whereItemnnme;
  }
  private String itemnnme;
  public void setItemnnme(String itemnnme){
    this.hasItemnnme = true;
    this.itemnnme = itemnnme;
  }
  public String getItemnnme(){
    return itemnnme;
  }
  private boolean hasOilfulltag;
  public boolean isHasOilfulltag(){
    return hasOilfulltag;
  }
  private boolean whereOilfulltag;
  public boolean isWhereOilfulltag(){
    return this.whereOilfulltag;
  }
  public void setWhereOilfulltag(boolean whereOilfulltag){
    this.whereOilfulltag = whereOilfulltag;
  }
  private int oilfulltag;
  public void setOilfulltag(int oilfulltag){
    this.hasOilfulltag = true;
    this.oilfulltag = oilfulltag;
  }
  public int getOilfulltag(){
    return oilfulltag;
  }
  private boolean hasParkcity;
  public boolean isHasParkcity(){
    return hasParkcity;
  }
  private boolean whereParkcity;
  public boolean isWhereParkcity(){
    return this.whereParkcity;
  }
  public void setWhereParkcity(boolean whereParkcity){
    this.whereParkcity = whereParkcity;
  }
  private String parkcity;
  public void setParkcity(String parkcity){
    this.hasParkcity = true;
    this.parkcity = parkcity;
  }
  public String getParkcity(){
    return parkcity;
  }
  private boolean hasActivetag;
  public boolean isHasActivetag(){
    return hasActivetag;
  }
  private boolean whereActivetag;
  public boolean isWhereActivetag(){
    return this.whereActivetag;
  }
  public void setWhereActivetag(boolean whereActivetag){
    this.whereActivetag = whereActivetag;
  }
  private int activetag;
  public void setActivetag(int activetag){
    this.hasActivetag = true;
    this.activetag = activetag;
  }
  public int getActivetag(){
    return activetag;
  }
}
