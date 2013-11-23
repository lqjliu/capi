package com.caru.vo;

public class CyvendorVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cyvendor";
  private boolean hasVendor;
  public boolean isHasVendor(){
    return hasVendor;
  }
  private boolean whereVendor;
  public boolean isWhereVendor(){
    return this.whereVendor;
  }
  public void setWhereVendor(boolean whereVendor){
    this.whereVendor = whereVendor;
  }
  private String vendor;
  public void setVendor(String vendor){
    this.hasVendor = true;
    this.vendor = vendor;
  }
  public String getVendor(){
    return vendor;
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
  private boolean hasHomemade;
  public boolean isHasHomemade(){
    return hasHomemade;
  }
  private boolean whereHomemade;
  public boolean isWhereHomemade(){
    return this.whereHomemade;
  }
  public void setWhereHomemade(boolean whereHomemade){
    this.whereHomemade = whereHomemade;
  }
  private int homemade;
  public void setHomemade(int homemade){
    this.hasHomemade = true;
    this.homemade = homemade;
  }
  public int getHomemade(){
    return homemade;
  }
}
