package com.carucrm.vo;

public class AccountVO implements java.io.Serializable{
  public static final String TABLE_NAME = "account";
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
  private boolean hasEmail;
  public boolean isHasEmail(){
    return hasEmail;
  }
  private boolean whereEmail;
  public boolean isWhereEmail(){
    return this.whereEmail;
  }
  public void setWhereEmail(boolean whereEmail){
    this.whereEmail = whereEmail;
  }
  private String email;
  public void setEmail(String email){
    this.hasEmail = true;
    this.email = email;
  }
  public String getEmail(){
    return email;
  }
  private boolean hasPassword;
  public boolean isHasPassword(){
    return hasPassword;
  }
  private boolean wherePassword;
  public boolean isWherePassword(){
    return this.wherePassword;
  }
  public void setWherePassword(boolean wherePassword){
    this.wherePassword = wherePassword;
  }
  private String password;
  public void setPassword(String password){
    this.hasPassword = true;
    this.password = password;
  }
  public String getPassword(){
    return password;
  }
  private boolean hasSalt;
  public boolean isHasSalt(){
    return hasSalt;
  }
  private boolean whereSalt;
  public boolean isWhereSalt(){
    return this.whereSalt;
  }
  public void setWhereSalt(boolean whereSalt){
    this.whereSalt = whereSalt;
  }
  private String salt;
  public void setSalt(String salt){
    this.hasSalt = true;
    this.salt = salt;
  }
  public String getSalt(){
    return salt;
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
  private boolean hasRole;
  public boolean isHasRole(){
    return hasRole;
  }
  private boolean whereRole;
  public boolean isWhereRole(){
    return this.whereRole;
  }
  public void setWhereRole(boolean whereRole){
    this.whereRole = whereRole;
  }
  private int role;
  public void setRole(int role){
    this.hasRole = true;
    this.role = role;
  }
  public int getRole(){
    return role;
  }
  private boolean hasCorporationid;
  public boolean isHasCorporationid(){
    return hasCorporationid;
  }
  private boolean whereCorporationid;
  public boolean isWhereCorporationid(){
    return this.whereCorporationid;
  }
  public void setWhereCorporationid(boolean whereCorporationid){
    this.whereCorporationid = whereCorporationid;
  }
  private int corporationid;
  public void setCorporationid(int corporationid){
    this.hasCorporationid = true;
    this.corporationid = corporationid;
  }
  public int getCorporationid(){
    return corporationid;
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
