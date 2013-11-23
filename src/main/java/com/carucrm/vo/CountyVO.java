package com.carucrm.vo;

public class CountyVO implements java.io.Serializable{
  public static final String TABLE_NAME = "county";
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
  private boolean hasPlatenumberprefix;
  public boolean isHasPlatenumberprefix(){
    return hasPlatenumberprefix;
  }
  private boolean wherePlatenumberprefix;
  public boolean isWherePlatenumberprefix(){
    return this.wherePlatenumberprefix;
  }
  public void setWherePlatenumberprefix(boolean wherePlatenumberprefix){
    this.wherePlatenumberprefix = wherePlatenumberprefix;
  }
  private String platenumberprefix;
  public void setPlatenumberprefix(String platenumberprefix){
    this.hasPlatenumberprefix = true;
    this.platenumberprefix = platenumberprefix;
  }
  public String getPlatenumberprefix(){
    return platenumberprefix;
  }
  private boolean hasAreacode;
  public boolean isHasAreacode(){
    return hasAreacode;
  }
  private boolean whereAreacode;
  public boolean isWhereAreacode(){
    return this.whereAreacode;
  }
  public void setWhereAreacode(boolean whereAreacode){
    this.whereAreacode = whereAreacode;
  }
  private String areacode;
  public void setAreacode(String areacode){
    this.hasAreacode = true;
    this.areacode = areacode;
  }
  public String getAreacode(){
    return areacode;
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
