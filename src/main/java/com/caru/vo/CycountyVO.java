package com.caru.vo;

public class CycountyVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cycounty";
  private boolean hasCounty;
  public boolean isHasCounty(){
    return hasCounty;
  }
  private boolean whereCounty;
  public boolean isWhereCounty(){
    return this.whereCounty;
  }
  public void setWhereCounty(boolean whereCounty){
    this.whereCounty = whereCounty;
  }
  private String county;
  public void setCounty(String county){
    this.hasCounty = true;
    this.county = county;
  }
  public String getCounty(){
    return county;
  }
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
  private boolean hasCountyid;
  public boolean isHasCountyid(){
    return hasCountyid;
  }
  private boolean whereCountyid;
  public boolean isWhereCountyid(){
    return this.whereCountyid;
  }
  public void setWhereCountyid(boolean whereCountyid){
    this.whereCountyid = whereCountyid;
  }
  private String countyid;
  public void setCountyid(String countyid){
    this.hasCountyid = true;
    this.countyid = countyid;
  }
  public String getCountyid(){
    return countyid;
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
  private String cityid;
  public void setCityid(String cityid){
    this.hasCityid = true;
    this.cityid = cityid;
  }
  public String getCityid(){
    return cityid;
  }
}
