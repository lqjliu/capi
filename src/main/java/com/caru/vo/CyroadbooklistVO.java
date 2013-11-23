package com.caru.vo;

public class CyroadbooklistVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cyroadbooklist";
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
  private boolean hasLinename;
  public boolean isHasLinename(){
    return hasLinename;
  }
  private boolean whereLinename;
  public boolean isWhereLinename(){
    return this.whereLinename;
  }
  public void setWhereLinename(boolean whereLinename){
    this.whereLinename = whereLinename;
  }
  private String linename;
  public void setLinename(String linename){
    this.hasLinename = true;
    this.linename = linename;
  }
  public String getLinename(){
    return linename;
  }
  private boolean hasStartpoint;
  public boolean isHasStartpoint(){
    return hasStartpoint;
  }
  private boolean whereStartpoint;
  public boolean isWhereStartpoint(){
    return this.whereStartpoint;
  }
  public void setWhereStartpoint(boolean whereStartpoint){
    this.whereStartpoint = whereStartpoint;
  }
  private String startpoint;
  public void setStartpoint(String startpoint){
    this.hasStartpoint = true;
    this.startpoint = startpoint;
  }
  public String getStartpoint(){
    return startpoint;
  }
  private boolean hasEndpoint;
  public boolean isHasEndpoint(){
    return hasEndpoint;
  }
  private boolean whereEndpoint;
  public boolean isWhereEndpoint(){
    return this.whereEndpoint;
  }
  public void setWhereEndpoint(boolean whereEndpoint){
    this.whereEndpoint = whereEndpoint;
  }
  private String endpoint;
  public void setEndpoint(String endpoint){
    this.hasEndpoint = true;
    this.endpoint = endpoint;
  }
  public String getEndpoint(){
    return endpoint;
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
  private boolean hasDayno;
  public boolean isHasDayno(){
    return hasDayno;
  }
  private boolean whereDayno;
  public boolean isWhereDayno(){
    return this.whereDayno;
  }
  public void setWhereDayno(boolean whereDayno){
    this.whereDayno = whereDayno;
  }
  private int dayno;
  public void setDayno(int dayno){
    this.hasDayno = true;
    this.dayno = dayno;
  }
  public int getDayno(){
    return dayno;
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
}
