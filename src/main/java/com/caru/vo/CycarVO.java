package com.caru.vo;

public class CycarVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cycar";
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
  private boolean hasStatus;
  public boolean isHasStatus(){
    return hasStatus;
  }
  private boolean whereStatus;
  public boolean isWhereStatus(){
    return this.whereStatus;
  }
  public void setWhereStatus(boolean whereStatus){
    this.whereStatus = whereStatus;
  }
  private int status;
  public void setStatus(int status){
    this.hasStatus = true;
    this.status = status;
  }
  public int getStatus(){
    return status;
  }
  private boolean hasNo;
  public boolean isHasNo(){
    return hasNo;
  }
  private boolean whereNo;
  public boolean isWhereNo(){
    return this.whereNo;
  }
  public void setWhereNo(boolean whereNo){
    this.whereNo = whereNo;
  }
  private int no;
  public void setNo(int no){
    this.hasNo = true;
    this.no = no;
  }
  public int getNo(){
    return no;
  }
  private boolean hasVendor;
  public boolean isHasVendor(){
    return hasVendor;
  }
  private boolean whereVendor;
  public boolean isWhereVendor(){
    return this.whereVendor;
  }
  public void setWhereVendor(boolean whereVendor){
    this.whereVendor = whereVendor;
  }
  private String vendor;
  public void setVendor(String vendor){
    this.hasVendor = true;
    this.vendor = vendor;
  }
  public String getVendor(){
    return vendor;
  }
  private boolean hasBrand;
  public boolean isHasBrand(){
    return hasBrand;
  }
  private boolean whereBrand;
  public boolean isWhereBrand(){
    return this.whereBrand;
  }
  public void setWhereBrand(boolean whereBrand){
    this.whereBrand = whereBrand;
  }
  private String brand;
  public void setBrand(String brand){
    this.hasBrand = true;
    this.brand = brand;
  }
  public String getBrand(){
    return brand;
  }
  private boolean hasParameter;
  public boolean isHasParameter(){
    return hasParameter;
  }
  private boolean whereParameter;
  public boolean isWhereParameter(){
    return this.whereParameter;
  }
  public void setWhereParameter(boolean whereParameter){
    this.whereParameter = whereParameter;
  }
  private String parameter;
  public void setParameter(String parameter){
    this.hasParameter = true;
    this.parameter = parameter;
  }
  public String getParameter(){
    return parameter;
  }
  private boolean hasProvince;
  public boolean isHasProvince(){
    return hasProvince;
  }
  private boolean whereProvince;
  public boolean isWhereProvince(){
    return this.whereProvince;
  }
  public void setWhereProvince(boolean whereProvince){
    this.whereProvince = whereProvince;
  }
  private String province;
  public void setProvince(String province){
    this.hasProvince = true;
    this.province = province;
  }
  public String getProvince(){
    return province;
  }
  private boolean hasCity;
  public boolean isHasCity(){
    return hasCity;
  }
  private boolean whereCity;
  public boolean isWhereCity(){
    return this.whereCity;
  }
  public void setWhereCity(boolean whereCity){
    this.whereCity = whereCity;
  }
  private String city;
  public void setCity(String city){
    this.hasCity = true;
    this.city = city;
  }
  public String getCity(){
    return city;
  }
  private boolean hasBuytype;
  public boolean isHasBuytype(){
    return hasBuytype;
  }
  private boolean whereBuytype;
  public boolean isWhereBuytype(){
    return this.whereBuytype;
  }
  public void setWhereBuytype(boolean whereBuytype){
    this.whereBuytype = whereBuytype;
  }
  private int buytype;
  public void setBuytype(int buytype){
    this.hasBuytype = true;
    this.buytype = buytype;
  }
  public int getBuytype(){
    return buytype;
  }
  private boolean hasBuytime;
  public boolean isHasBuytime(){
    return hasBuytime;
  }
  private boolean whereBuytime;
  public boolean isWhereBuytime(){
    return this.whereBuytime;
  }
  public void setWhereBuytime(boolean whereBuytime){
    this.whereBuytime = whereBuytime;
  }
  private java.util.Date buytime;
  public void setBuytime(java.util.Date buytime){
    this.hasBuytime = true;
    this.buytime = buytime;
  }
  public java.util.Date getBuytime(){
    return buytime;
  }
  private boolean hasNickname;
  public boolean isHasNickname(){
    return hasNickname;
  }
  private boolean whereNickname;
  public boolean isWhereNickname(){
    return this.whereNickname;
  }
  public void setWhereNickname(boolean whereNickname){
    this.whereNickname = whereNickname;
  }
  private String nickname;
  public void setNickname(String nickname){
    this.hasNickname = true;
    this.nickname = nickname;
  }
  public String getNickname(){
    return nickname;
  }
  private boolean hasPhoto;
  public boolean isHasPhoto(){
    return hasPhoto;
  }
  private boolean wherePhoto;
  public boolean isWherePhoto(){
    return this.wherePhoto;
  }
  public void setWherePhoto(boolean wherePhoto){
    this.wherePhoto = wherePhoto;
  }
  private String photo;
  public void setPhoto(String photo){
    this.hasPhoto = true;
    this.photo = photo;
  }
  public String getPhoto(){
    return photo;
  }
  private boolean hasDealer;
  public boolean isHasDealer(){
    return hasDealer;
  }
  private boolean whereDealer;
  public boolean isWhereDealer(){
    return this.whereDealer;
  }
  public void setWhereDealer(boolean whereDealer){
    this.whereDealer = whereDealer;
  }
  private String dealer;
  public void setDealer(String dealer){
    this.hasDealer = true;
    this.dealer = dealer;
  }
  public String getDealer(){
    return dealer;
  }
  private boolean hasContactname;
  public boolean isHasContactname(){
    return hasContactname;
  }
  private boolean whereContactname;
  public boolean isWhereContactname(){
    return this.whereContactname;
  }
  public void setWhereContactname(boolean whereContactname){
    this.whereContactname = whereContactname;
  }
  private String contactname;
  public void setContactname(String contactname){
    this.hasContactname = true;
    this.contactname = contactname;
  }
  public String getContactname(){
    return contactname;
  }
  private boolean hasContacttelephone;
  public boolean isHasContacttelephone(){
    return hasContacttelephone;
  }
  private boolean whereContacttelephone;
  public boolean isWhereContacttelephone(){
    return this.whereContacttelephone;
  }
  public void setWhereContacttelephone(boolean whereContacttelephone){
    this.whereContacttelephone = whereContacttelephone;
  }
  private String contacttelephone;
  public void setContacttelephone(String contacttelephone){
    this.hasContacttelephone = true;
    this.contacttelephone = contacttelephone;
  }
  public String getContacttelephone(){
    return contacttelephone;
  }
  private boolean hasCreattime;
  public boolean isHasCreattime(){
    return hasCreattime;
  }
  private boolean whereCreattime;
  public boolean isWhereCreattime(){
    return this.whereCreattime;
  }
  public void setWhereCreattime(boolean whereCreattime){
    this.whereCreattime = whereCreattime;
  }
  private java.util.Date creattime;
  public void setCreattime(java.util.Date creattime){
    this.hasCreattime = true;
    this.creattime = creattime;
  }
  public java.util.Date getCreattime(){
    return creattime;
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
