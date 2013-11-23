package com.caru.vo;

public class CyuserpreferenceVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cyuserpreference";
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
  private boolean hasItemname;
  public boolean isHasItemname(){
    return hasItemname;
  }
  private boolean whereItemname;
  public boolean isWhereItemname(){
    return this.whereItemname;
  }
  public void setWhereItemname(boolean whereItemname){
    this.whereItemname = whereItemname;
  }
  private String itemname;
  public void setItemname(String itemname){
    this.hasItemname = true;
    this.itemname = itemname;
  }
  public String getItemname(){
    return itemname;
  }
  private boolean hasItemvalue;
  public boolean isHasItemvalue(){
    return hasItemvalue;
  }
  private boolean whereItemvalue;
  public boolean isWhereItemvalue(){
    return this.whereItemvalue;
  }
  public void setWhereItemvalue(boolean whereItemvalue){
    this.whereItemvalue = whereItemvalue;
  }
  private String itemvalue;
  public void setItemvalue(String itemvalue){
    this.hasItemvalue = true;
    this.itemvalue = itemvalue;
  }
  public String getItemvalue(){
    return itemvalue;
  }
  private boolean hasCreatetime;
  public boolean isHasCreatetime(){
    return hasCreatetime;
  }
  private boolean whereCreatetime;
  public boolean isWhereCreatetime(){
    return this.whereCreatetime;
  }
  public void setWhereCreatetime(boolean whereCreatetime){
    this.whereCreatetime = whereCreatetime;
  }
  private java.util.Date createtime;
  public void setCreatetime(java.util.Date createtime){
    this.hasCreatetime = true;
    this.createtime = createtime;
  }
  public java.util.Date getCreatetime(){
    return createtime;
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
