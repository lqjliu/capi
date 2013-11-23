package com.caru.vo;

public class CarVO implements java.io.Serializable{
  public static final String TABLE_NAME = "car";
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
  private boolean hasPurchasedtag;
  public boolean isHasPurchasedtag(){
    return hasPurchasedtag;
  }
  private boolean wherePurchasedtag;
  public boolean isWherePurchasedtag(){
    return this.wherePurchasedtag;
  }
  public void setWherePurchasedtag(boolean wherePurchasedtag){
    this.wherePurchasedtag = wherePurchasedtag;
  }
  private int purchasedtag;
  public void setPurchasedtag(int purchasedtag){
    this.hasPurchasedtag = true;
    this.purchasedtag = purchasedtag;
  }
  public int getPurchasedtag(){
    return purchasedtag;
  }
  private boolean hasVenderid;
  public boolean isHasVenderid(){
    return hasVenderid;
  }
  private boolean whereVenderid;
  public boolean isWhereVenderid(){
    return this.whereVenderid;
  }
  public void setWhereVenderid(boolean whereVenderid){
    this.whereVenderid = whereVenderid;
  }
  private int venderid;
  public void setVenderid(int venderid){
    this.hasVenderid = true;
    this.venderid = venderid;
  }
  public int getVenderid(){
    return venderid;
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
  private boolean hasModeldiyname;
  public boolean isHasModeldiyname(){
    return hasModeldiyname;
  }
  private boolean whereModeldiyname;
  public boolean isWhereModeldiyname(){
    return this.whereModeldiyname;
  }
  public void setWhereModeldiyname(boolean whereModeldiyname){
    this.whereModeldiyname = whereModeldiyname;
  }
  private String modeldiyname;
  public void setModeldiyname(String modeldiyname){
    this.hasModeldiyname = true;
    this.modeldiyname = modeldiyname;
  }
  public String getModeldiyname(){
    return modeldiyname;
  }
  private boolean hasPurchasedtype;
  public boolean isHasPurchasedtype(){
    return hasPurchasedtype;
  }
  private boolean wherePurchasedtype;
  public boolean isWherePurchasedtype(){
    return this.wherePurchasedtype;
  }
  public void setWherePurchasedtype(boolean wherePurchasedtype){
    this.wherePurchasedtype = wherePurchasedtype;
  }
  private int purchasedtype;
  public void setPurchasedtype(int purchasedtype){
    this.hasPurchasedtype = true;
    this.purchasedtype = purchasedtype;
  }
  public int getPurchasedtype(){
    return purchasedtype;
  }
  private boolean hasPurchaseddate;
  public boolean isHasPurchaseddate(){
    return hasPurchaseddate;
  }
  private boolean wherePurchaseddate;
  public boolean isWherePurchaseddate(){
    return this.wherePurchaseddate;
  }
  public void setWherePurchaseddate(boolean wherePurchaseddate){
    this.wherePurchaseddate = wherePurchaseddate;
  }
  private java.util.Date purchaseddate;
  public void setPurchaseddate(java.util.Date purchaseddate){
    this.hasPurchaseddate = true;
    this.purchaseddate = purchaseddate;
  }
  public java.util.Date getPurchaseddate(){
    return purchaseddate;
  }
  private boolean hasTankvolume;
  public boolean isHasTankvolume(){
    return hasTankvolume;
  }
  private boolean whereTankvolume;
  public boolean isWhereTankvolume(){
    return this.whereTankvolume;
  }
  public void setWhereTankvolume(boolean whereTankvolume){
    this.whereTankvolume = whereTankvolume;
  }
  private int tankvolume;
  public void setTankvolume(int tankvolume){
    this.hasTankvolume = true;
    this.tankvolume = tankvolume;
  }
  public int getTankvolume(){
    return tankvolume;
  }
  private boolean hasTotalprice;
  public boolean isHasTotalprice(){
    return hasTotalprice;
  }
  private boolean whereTotalprice;
  public boolean isWhereTotalprice(){
    return this.whereTotalprice;
  }
  public void setWhereTotalprice(boolean whereTotalprice){
    this.whereTotalprice = whereTotalprice;
  }
  private double totalprice;
  public void setTotalprice(double totalprice){
    this.hasTotalprice = true;
    this.totalprice = totalprice;
  }
  public double getTotalprice(){
    return totalprice;
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
  private boolean hasQuickinforange;
  public boolean isHasQuickinforange(){
    return hasQuickinforange;
  }
  private boolean whereQuickinforange;
  public boolean isWhereQuickinforange(){
    return this.whereQuickinforange;
  }
  public void setWhereQuickinforange(boolean whereQuickinforange){
    this.whereQuickinforange = whereQuickinforange;
  }
  private String quickinforange;
  public void setQuickinforange(String quickinforange){
    this.hasQuickinforange = true;
    this.quickinforange = quickinforange;
  }
  public String getQuickinforange(){
    return quickinforange;
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
