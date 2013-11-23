package com.caru.vo;

public class FeelistVO implements java.io.Serializable{
  public static final String TABLE_NAME = "feelist";
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
  private boolean hasAmmount;
  public boolean isHasAmmount(){
    return hasAmmount;
  }
  private boolean whereAmmount;
  public boolean isWhereAmmount(){
    return this.whereAmmount;
  }
  public void setWhereAmmount(boolean whereAmmount){
    this.whereAmmount = whereAmmount;
  }
  private double ammount;
  public void setAmmount(double ammount){
    this.hasAmmount = true;
    this.ammount = ammount;
  }
  public double getAmmount(){
    return ammount;
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
  private boolean hasRestr1;
  public boolean isHasRestr1(){
    return hasRestr1;
  }
  private boolean whereRestr1;
  public boolean isWhereRestr1(){
    return this.whereRestr1;
  }
  public void setWhereRestr1(boolean whereRestr1){
    this.whereRestr1 = whereRestr1;
  }
  private String restr1;
  public void setRestr1(String restr1){
    this.hasRestr1 = true;
    this.restr1 = restr1;
  }
  public String getRestr1(){
    return restr1;
  }
  private boolean hasRestr2;
  public boolean isHasRestr2(){
    return hasRestr2;
  }
  private boolean whereRestr2;
  public boolean isWhereRestr2(){
    return this.whereRestr2;
  }
  public void setWhereRestr2(boolean whereRestr2){
    this.whereRestr2 = whereRestr2;
  }
  private String restr2;
  public void setRestr2(String restr2){
    this.hasRestr2 = true;
    this.restr2 = restr2;
  }
  public String getRestr2(){
    return restr2;
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
