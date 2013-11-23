package com.caru.vo;

public class CymodelVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cymodel";
  private boolean hasModel;
  public boolean isHasModel(){
    return hasModel;
  }
  private boolean whereModel;
  public boolean isWhereModel(){
    return this.whereModel;
  }
  public void setWhereModel(boolean whereModel){
    this.whereModel = whereModel;
  }
  private String model;
  public void setModel(String model){
    this.hasModel = true;
    this.model = model;
  }
  public String getModel(){
    return model;
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
  private boolean hasBrandid;
  public boolean isHasBrandid(){
    return hasBrandid;
  }
  private boolean whereBrandid;
  public boolean isWhereBrandid(){
    return this.whereBrandid;
  }
  public void setWhereBrandid(boolean whereBrandid){
    this.whereBrandid = whereBrandid;
  }
  private int brandid;
  public void setBrandid(int brandid){
    this.hasBrandid = true;
    this.brandid = brandid;
  }
  public int getBrandid(){
    return brandid;
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
  private boolean hasOilbox;
  public boolean isHasOilbox(){
    return hasOilbox;
  }
  private boolean whereOilbox;
  public boolean isWhereOilbox(){
    return this.whereOilbox;
  }
  public void setWhereOilbox(boolean whereOilbox){
    this.whereOilbox = whereOilbox;
  }
  private String oilbox;
  public void setOilbox(String oilbox){
    this.hasOilbox = true;
    this.oilbox = oilbox;
  }
  public String getOilbox(){
    return oilbox;
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
