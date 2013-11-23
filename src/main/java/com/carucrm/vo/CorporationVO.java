package com.carucrm.vo;

public class CorporationVO implements java.io.Serializable{
  public static final String TABLE_NAME = "corporation";
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
  private boolean hasSymbol;
  public boolean isHasSymbol(){
    return hasSymbol;
  }
  private boolean whereSymbol;
  public boolean isWhereSymbol(){
    return this.whereSymbol;
  }
  public void setWhereSymbol(boolean whereSymbol){
    this.whereSymbol = whereSymbol;
  }
  private String symbol;
  public void setSymbol(String symbol){
    this.hasSymbol = true;
    this.symbol = symbol;
  }
  public String getSymbol(){
    return symbol;
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
  private boolean hasServiceitems;
  public boolean isHasServiceitems(){
    return hasServiceitems;
  }
  private boolean whereServiceitems;
  public boolean isWhereServiceitems(){
    return this.whereServiceitems;
  }
  public void setWhereServiceitems(boolean whereServiceitems){
    this.whereServiceitems = whereServiceitems;
  }
  private String serviceitems;
  public void setServiceitems(String serviceitems){
    this.hasServiceitems = true;
    this.serviceitems = serviceitems;
  }
  public String getServiceitems(){
    return serviceitems;
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
  private int provinceid;
  public void setProvinceid(int provinceid){
    this.hasProvinceid = true;
    this.provinceid = provinceid;
  }
  public int getProvinceid(){
    return provinceid;
  }
  private boolean hasCityid;
  public boolean isHasCityid(){
    return hasCityid;
  }
  private boolean whereCityid;
  public boolean isWhereCityid(){
    return this.whereCityid;
  }
  public void setWhereCityid(boolean whereCityid){
    this.whereCityid = whereCityid;
  }
  private int cityid;
  public void setCityid(int cityid){
    this.hasCityid = true;
    this.cityid = cityid;
  }
  public int getCityid(){
    return cityid;
  }
  private boolean hasCountyid;
  public boolean isHasCountyid(){
    return hasCountyid;
  }
  private boolean whereCountyid;
  public boolean isWhereCountyid(){
    return this.whereCountyid;
  }
  public void setWhereCountyid(boolean whereCountyid){
    this.whereCountyid = whereCountyid;
  }
  private int countyid;
  public void setCountyid(int countyid){
    this.hasCountyid = true;
    this.countyid = countyid;
  }
  public int getCountyid(){
    return countyid;
  }
  private boolean hasAddress;
  public boolean isHasAddress(){
    return hasAddress;
  }
  private boolean whereAddress;
  public boolean isWhereAddress(){
    return this.whereAddress;
  }
  public void setWhereAddress(boolean whereAddress){
    this.whereAddress = whereAddress;
  }
  private String address;
  public void setAddress(String address){
    this.hasAddress = true;
    this.address = address;
  }
  public String getAddress(){
    return address;
  }
  private boolean hasPlatenumberprefix;
  public boolean isHasPlatenumberprefix(){
    return hasPlatenumberprefix;
  }
  private boolean wherePlatenumberprefix;
  public boolean isWherePlatenumberprefix(){
    return this.wherePlatenumberprefix;
  }
  public void setWherePlatenumberprefix(boolean wherePlatenumberprefix){
    this.wherePlatenumberprefix = wherePlatenumberprefix;
  }
  private String platenumberprefix;
  public void setPlatenumberprefix(String platenumberprefix){
    this.hasPlatenumberprefix = true;
    this.platenumberprefix = platenumberprefix;
  }
  public String getPlatenumberprefix(){
    return platenumberprefix;
  }
  private boolean hasContactid;
  public boolean isHasContactid(){
    return hasContactid;
  }
  private boolean whereContactid;
  public boolean isWhereContactid(){
    return this.whereContactid;
  }
  public void setWhereContactid(boolean whereContactid){
    this.whereContactid = whereContactid;
  }
  private int contactid;
  public void setContactid(int contactid){
    this.hasContactid = true;
    this.contactid = contactid;
  }
  public int getContactid(){
    return contactid;
  }
  private boolean hasCsphone1areacode;
  public boolean isHasCsphone1areacode(){
    return hasCsphone1areacode;
  }
  private boolean whereCsphone1areacode;
  public boolean isWhereCsphone1areacode(){
    return this.whereCsphone1areacode;
  }
  public void setWhereCsphone1areacode(boolean whereCsphone1areacode){
    this.whereCsphone1areacode = whereCsphone1areacode;
  }
  private String csphone1areacode;
  public void setCsphone1areacode(String csphone1areacode){
    this.hasCsphone1areacode = true;
    this.csphone1areacode = csphone1areacode;
  }
  public String getCsphone1areacode(){
    return csphone1areacode;
  }
  private boolean hasCsphone1;
  public boolean isHasCsphone1(){
    return hasCsphone1;
  }
  private boolean whereCsphone1;
  public boolean isWhereCsphone1(){
    return this.whereCsphone1;
  }
  public void setWhereCsphone1(boolean whereCsphone1){
    this.whereCsphone1 = whereCsphone1;
  }
  private String csphone1;
  public void setCsphone1(String csphone1){
    this.hasCsphone1 = true;
    this.csphone1 = csphone1;
  }
  public String getCsphone1(){
    return csphone1;
  }
  private boolean hasCsphone2areacode;
  public boolean isHasCsphone2areacode(){
    return hasCsphone2areacode;
  }
  private boolean whereCsphone2areacode;
  public boolean isWhereCsphone2areacode(){
    return this.whereCsphone2areacode;
  }
  public void setWhereCsphone2areacode(boolean whereCsphone2areacode){
    this.whereCsphone2areacode = whereCsphone2areacode;
  }
  private String csphone2areacode;
  public void setCsphone2areacode(String csphone2areacode){
    this.hasCsphone2areacode = true;
    this.csphone2areacode = csphone2areacode;
  }
  public String getCsphone2areacode(){
    return csphone2areacode;
  }
  private boolean hasCsphone2;
  public boolean isHasCsphone2(){
    return hasCsphone2;
  }
  private boolean whereCsphone2;
  public boolean isWhereCsphone2(){
    return this.whereCsphone2;
  }
  public void setWhereCsphone2(boolean whereCsphone2){
    this.whereCsphone2 = whereCsphone2;
  }
  private String csphone2;
  public void setCsphone2(String csphone2){
    this.hasCsphone2 = true;
    this.csphone2 = csphone2;
  }
  public String getCsphone2(){
    return csphone2;
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
