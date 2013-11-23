package com.caru.vo;

public class UserVO implements java.io.Serializable{
  public static final String TABLE_NAME = "user";
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
  private boolean hasAcceptsiterule;
  public boolean isHasAcceptsiterule(){
    return hasAcceptsiterule;
  }
  private boolean whereAcceptsiterule;
  public boolean isWhereAcceptsiterule(){
    return this.whereAcceptsiterule;
  }
  public void setWhereAcceptsiterule(boolean whereAcceptsiterule){
    this.whereAcceptsiterule = whereAcceptsiterule;
  }
  private int acceptsiterule;
  public void setAcceptsiterule(int acceptsiterule){
    this.hasAcceptsiterule = true;
    this.acceptsiterule = acceptsiterule;
  }
  public int getAcceptsiterule(){
    return acceptsiterule;
  }
  private boolean hasFeeinputmode;
  public boolean isHasFeeinputmode(){
    return hasFeeinputmode;
  }
  private boolean whereFeeinputmode;
  public boolean isWhereFeeinputmode(){
    return this.whereFeeinputmode;
  }
  public void setWhereFeeinputmode(boolean whereFeeinputmode){
    this.whereFeeinputmode = whereFeeinputmode;
  }
  private int feeinputmode;
  public void setFeeinputmode(int feeinputmode){
    this.hasFeeinputmode = true;
    this.feeinputmode = feeinputmode;
  }
  public int getFeeinputmode(){
    return feeinputmode;
  }
  private boolean hasLastlogindate;
  public boolean isHasLastlogindate(){
    return hasLastlogindate;
  }
  private boolean whereLastlogindate;
  public boolean isWhereLastlogindate(){
    return this.whereLastlogindate;
  }
  public void setWhereLastlogindate(boolean whereLastlogindate){
    this.whereLastlogindate = whereLastlogindate;
  }
  private java.util.Date lastlogindate;
  public void setLastlogindate(java.util.Date lastlogindate){
    this.hasLastlogindate = true;
    this.lastlogindate = lastlogindate;
  }
  public java.util.Date getLastlogindate(){
    return lastlogindate;
  }
  private boolean hasLastloginip;
  public boolean isHasLastloginip(){
    return hasLastloginip;
  }
  private boolean whereLastloginip;
  public boolean isWhereLastloginip(){
    return this.whereLastloginip;
  }
  public void setWhereLastloginip(boolean whereLastloginip){
    this.whereLastloginip = whereLastloginip;
  }
  private String lastloginip;
  public void setLastloginip(String lastloginip){
    this.hasLastloginip = true;
    this.lastloginip = lastloginip;
  }
  public String getLastloginip(){
    return lastloginip;
  }
  private boolean hasLoginsequence;
  public boolean isHasLoginsequence(){
    return hasLoginsequence;
  }
  private boolean whereLoginsequence;
  public boolean isWhereLoginsequence(){
    return this.whereLoginsequence;
  }
  public void setWhereLoginsequence(boolean whereLoginsequence){
    this.whereLoginsequence = whereLoginsequence;
  }
  private int loginsequence;
  public void setLoginsequence(int loginsequence){
    this.hasLoginsequence = true;
    this.loginsequence = loginsequence;
  }
  public int getLoginsequence(){
    return loginsequence;
  }
  private boolean hasRegisterdate;
  public boolean isHasRegisterdate(){
    return hasRegisterdate;
  }
  private boolean whereRegisterdate;
  public boolean isWhereRegisterdate(){
    return this.whereRegisterdate;
  }
  public void setWhereRegisterdate(boolean whereRegisterdate){
    this.whereRegisterdate = whereRegisterdate;
  }
  private java.util.Date registerdate;
  public void setRegisterdate(java.util.Date registerdate){
    this.hasRegisterdate = true;
    this.registerdate = registerdate;
  }
  public java.util.Date getRegisterdate(){
    return registerdate;
  }
  private boolean hasRegisterip;
  public boolean isHasRegisterip(){
    return hasRegisterip;
  }
  private boolean whereRegisterip;
  public boolean isWhereRegisterip(){
    return this.whereRegisterip;
  }
  public void setWhereRegisterip(boolean whereRegisterip){
    this.whereRegisterip = whereRegisterip;
  }
  private String registerip;
  public void setRegisterip(String registerip){
    this.hasRegisterip = true;
    this.registerip = registerip;
  }
  public String getRegisterip(){
    return registerip;
  }
  private boolean hasRegisterrefform;
  public boolean isHasRegisterrefform(){
    return hasRegisterrefform;
  }
  private boolean whereRegisterrefform;
  public boolean isWhereRegisterrefform(){
    return this.whereRegisterrefform;
  }
  public void setWhereRegisterrefform(boolean whereRegisterrefform){
    this.whereRegisterrefform = whereRegisterrefform;
  }
  private String registerrefform;
  public void setRegisterrefform(String registerrefform){
    this.hasRegisterrefform = true;
    this.registerrefform = registerrefform;
  }
  public String getRegisterrefform(){
    return registerrefform;
  }
  private boolean hasUrlafterlogin;
  public boolean isHasUrlafterlogin(){
    return hasUrlafterlogin;
  }
  private boolean whereUrlafterlogin;
  public boolean isWhereUrlafterlogin(){
    return this.whereUrlafterlogin;
  }
  public void setWhereUrlafterlogin(boolean whereUrlafterlogin){
    this.whereUrlafterlogin = whereUrlafterlogin;
  }
  private String urlafterlogin;
  public void setUrlafterlogin(String urlafterlogin){
    this.hasUrlafterlogin = true;
    this.urlafterlogin = urlafterlogin;
  }
  public String getUrlafterlogin(){
    return urlafterlogin;
  }
  private boolean hasActivetag;
  public boolean isHasActivetag(){
    return hasActivetag;
  }
  private boolean whereActivetag;
  public boolean isWhereActivetag(){
    return this.whereActivetag;
  }
  public void setWhereActivetag(boolean whereActivetag){
    this.whereActivetag = whereActivetag;
  }
  private int activetag;
  public void setActivetag(int activetag){
    this.hasActivetag = true;
    this.activetag = activetag;
  }
  public int getActivetag(){
    return activetag;
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
