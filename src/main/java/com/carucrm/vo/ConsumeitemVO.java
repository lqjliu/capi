package com.carucrm.vo;

public class ConsumeitemVO implements java.io.Serializable{
  public static final String TABLE_NAME = "consumeitem";
  private boolean hasConsumeid;
  public boolean isHasConsumeid(){
    return hasConsumeid;
  }
  private boolean whereConsumeid;
  public boolean isWhereConsumeid(){
    return this.whereConsumeid;
  }
  public void setWhereConsumeid(boolean whereConsumeid){
    this.whereConsumeid = whereConsumeid;
  }
  private int consumeid;
  public void setConsumeid(int consumeid){
    this.hasConsumeid = true;
    this.consumeid = consumeid;
  }
  public int getConsumeid(){
    return consumeid;
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
  private boolean hasUnit;
  public boolean isHasUnit(){
    return hasUnit;
  }
  private boolean whereUnit;
  public boolean isWhereUnit(){
    return this.whereUnit;
  }
  public void setWhereUnit(boolean whereUnit){
    this.whereUnit = whereUnit;
  }
  private String unit;
  public void setUnit(String unit){
    this.hasUnit = true;
    this.unit = unit;
  }
  public String getUnit(){
    return unit;
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
  private boolean hasAmount;
  public boolean isHasAmount(){
    return hasAmount;
  }
  private boolean whereAmount;
  public boolean isWhereAmount(){
    return this.whereAmount;
  }
  public void setWhereAmount(boolean whereAmount){
    this.whereAmount = whereAmount;
  }
  private double amount;
  public void setAmount(double amount){
    this.hasAmount = true;
    this.amount = amount;
  }
  public double getAmount(){
    return amount;
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
