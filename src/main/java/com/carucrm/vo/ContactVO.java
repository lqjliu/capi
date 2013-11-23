package com.carucrm.vo;

public class ContactVO implements java.io.Serializable{
  public static final String TABLE_NAME = "contact";
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
