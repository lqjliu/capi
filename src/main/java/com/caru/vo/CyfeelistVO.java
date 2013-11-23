package com.caru.vo;

public class CyfeelistVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cyfeelist";
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
  private boolean hasMoney;
  public boolean isHasMoney(){
    return hasMoney;
  }
  private boolean whereMoney;
  public boolean isWhereMoney(){
    return this.whereMoney;
  }
  public void setWhereMoney(boolean whereMoney){
    this.whereMoney = whereMoney;
  }
  private double money;
  public void setMoney(double money){
    this.hasMoney = true;
    this.money = money;
  }
  public double getMoney(){
    return money;
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
  private boolean hasDescription;
  public boolean isHasDescription(){
    return hasDescription;
  }
  private boolean whereDescription;
  public boolean isWhereDescription(){
    return this.whereDescription;
  }
  public void setWhereDescription(boolean whereDescription){
    this.whereDescription = whereDescription;
  }
  private String description;
  public void setDescription(String description){
    this.hasDescription = true;
    this.description = description;
  }
  public String getDescription(){
    return description;
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
