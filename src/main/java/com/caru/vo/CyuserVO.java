package com.caru.vo;

public class CyuserVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cyuser";
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
  private boolean hasUsername;
  public boolean isHasUsername(){
    return hasUsername;
  }
  private boolean whereUsername;
  public boolean isWhereUsername(){
    return this.whereUsername;
  }
  public void setWhereUsername(boolean whereUsername){
    this.whereUsername = whereUsername;
  }
  private String username;
  public void setUsername(String username){
    this.hasUsername = true;
    this.username = username;
  }
  public String getUsername(){
    return username;
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
