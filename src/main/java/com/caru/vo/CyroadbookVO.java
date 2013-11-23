package com.caru.vo;

public class CyroadbookVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cyroadbook";
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
  private boolean hasRoadbookid;
  public boolean isHasRoadbookid(){
    return hasRoadbookid;
  }
  private boolean whereRoadbookid;
  public boolean isWhereRoadbookid(){
    return this.whereRoadbookid;
  }
  public void setWhereRoadbookid(boolean whereRoadbookid){
    this.whereRoadbookid = whereRoadbookid;
  }
  private int roadbookid;
  public void setRoadbookid(int roadbookid){
    this.hasRoadbookid = true;
    this.roadbookid = roadbookid;
  }
  public int getRoadbookid(){
    return roadbookid;
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
  private boolean hasStartdate;
  public boolean isHasStartdate(){
    return hasStartdate;
  }
  private boolean whereStartdate;
  public boolean isWhereStartdate(){
    return this.whereStartdate;
  }
  public void setWhereStartdate(boolean whereStartdate){
    this.whereStartdate = whereStartdate;
  }
  private java.util.Date startdate;
  public void setStartdate(java.util.Date startdate){
    this.hasStartdate = true;
    this.startdate = startdate;
  }
  public java.util.Date getStartdate(){
    return startdate;
  }
  private boolean hasEnddate;
  public boolean isHasEnddate(){
    return hasEnddate;
  }
  private boolean whereEnddate;
  public boolean isWhereEnddate(){
    return this.whereEnddate;
  }
  public void setWhereEnddate(boolean whereEnddate){
    this.whereEnddate = whereEnddate;
  }
  private java.util.Date enddate;
  public void setEnddate(java.util.Date enddate){
    this.hasEnddate = true;
    this.enddate = enddate;
  }
  public java.util.Date getEnddate(){
    return enddate;
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
  private boolean hasEndcity;
  public boolean isHasEndcity(){
    return hasEndcity;
  }
  private boolean whereEndcity;
  public boolean isWhereEndcity(){
    return this.whereEndcity;
  }
  public void setWhereEndcity(boolean whereEndcity){
    this.whereEndcity = whereEndcity;
  }
  private String endcity;
  public void setEndcity(String endcity){
    this.hasEndcity = true;
    this.endcity = endcity;
  }
  public String getEndcity(){
    return endcity;
  }
  private boolean hasEndplace;
  public boolean isHasEndplace(){
    return hasEndplace;
  }
  private boolean whereEndplace;
  public boolean isWhereEndplace(){
    return this.whereEndplace;
  }
  public void setWhereEndplace(boolean whereEndplace){
    this.whereEndplace = whereEndplace;
  }
  private String endplace;
  public void setEndplace(String endplace){
    this.hasEndplace = true;
    this.endplace = endplace;
  }
  public String getEndplace(){
    return endplace;
  }
  private boolean hasBrief;
  public boolean isHasBrief(){
    return hasBrief;
  }
  private boolean whereBrief;
  public boolean isWhereBrief(){
    return this.whereBrief;
  }
  public void setWhereBrief(boolean whereBrief){
    this.whereBrief = whereBrief;
  }
  private String brief;
  public void setBrief(String brief){
    this.hasBrief = true;
    this.brief = brief;
  }
  public String getBrief(){
    return brief;
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
