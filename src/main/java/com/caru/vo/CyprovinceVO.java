package com.caru.vo;

public class CyprovinceVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cyprovince";
  private boolean hasProvince;
  public boolean isHasProvince(){
    return hasProvince;
  }
  private boolean whereProvince;
  public boolean isWhereProvince(){
    return this.whereProvince;
  }
  public void setWhereProvince(boolean whereProvince){
    this.whereProvince = whereProvince;
  }
  private String province;
  public void setProvince(String province){
    this.hasProvince = true;
    this.province = province;
  }
  public String getProvince(){
    return province;
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
  private boolean hasProvinceid;
  public boolean isHasProvinceid(){
    return hasProvinceid;
  }
  private boolean whereProvinceid;
  public boolean isWhereProvinceid(){
    return this.whereProvinceid;
  }
  public void setWhereProvinceid(boolean whereProvinceid){
    this.whereProvinceid = whereProvinceid;
  }
  private String provinceid;
  public void setProvinceid(String provinceid){
    this.hasProvinceid = true;
    this.provinceid = provinceid;
  }
  public String getProvinceid(){
    return provinceid;
  }
}
