package com.caru.vo;

public class CycityVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cycity";
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
  private String provinceid;
  public void setProvinceid(String provinceid){
    this.hasProvinceid = true;
    this.provinceid = provinceid;
  }
  public String getProvinceid(){
    return provinceid;
  }
}
