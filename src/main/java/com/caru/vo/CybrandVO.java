package com.caru.vo;

public class CybrandVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cybrand";
  private boolean hasBrand;
  public boolean isHasBrand(){
    return hasBrand;
  }
  private boolean whereBrand;
  public boolean isWhereBrand(){
    return this.whereBrand;
  }
  public void setWhereBrand(boolean whereBrand){
    this.whereBrand = whereBrand;
  }
  private String brand;
  public void setBrand(String brand){
    this.hasBrand = true;
    this.brand = brand;
  }
  public String getBrand(){
    return brand;
  }
  private boolean hasVendorid;
  public boolean isHasVendorid(){
    return hasVendorid;
  }
  private boolean whereVendorid;
  public boolean isWhereVendorid(){
    return this.whereVendorid;
  }
  public void setWhereVendorid(boolean whereVendorid){
    this.whereVendorid = whereVendorid;
  }
  private int vendorid;
  public void setVendorid(int vendorid){
    this.hasVendorid = true;
    this.vendorid = vendorid;
  }
  public int getVendorid(){
    return vendorid;
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
}
