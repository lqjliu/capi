package com.caru.vo;

public class CyblogVO implements java.io.Serializable{
  public static final String TABLE_NAME = "cyblog";
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
  private boolean hasBlogid;
  public boolean isHasBlogid(){
    return hasBlogid;
  }
  private boolean whereBlogid;
  public boolean isWhereBlogid(){
    return this.whereBlogid;
  }
  public void setWhereBlogid(boolean whereBlogid){
    this.whereBlogid = whereBlogid;
  }
  private int blogid;
  public void setBlogid(int blogid){
    this.hasBlogid = true;
    this.blogid = blogid;
  }
  public int getBlogid(){
    return blogid;
  }
  private boolean hasTopic;
  public boolean isHasTopic(){
    return hasTopic;
  }
  private boolean whereTopic;
  public boolean isWhereTopic(){
    return this.whereTopic;
  }
  public void setWhereTopic(boolean whereTopic){
    this.whereTopic = whereTopic;
  }
  private String topic;
  public void setTopic(String topic){
    this.hasTopic = true;
    this.topic = topic;
  }
  public String getTopic(){
    return topic;
  }
  private boolean hasBrief;
  public boolean isHasBrief(){
    return hasBrief;
  }
  private boolean whereBrief;
  public boolean isWhereBrief(){
    return this.whereBrief;
  }
  public void setWhereBrief(boolean whereBrief){
    this.whereBrief = whereBrief;
  }
  private String brief;
  public void setBrief(String brief){
    this.hasBrief = true;
    this.brief = brief;
  }
  public String getBrief(){
    return brief;
  }
  private boolean hasContent;
  public boolean isHasContent(){
    return hasContent;
  }
  private boolean whereContent;
  public boolean isWhereContent(){
    return this.whereContent;
  }
  public void setWhereContent(boolean whereContent){
    this.whereContent = whereContent;
  }
  private String content;
  public void setContent(String content){
    this.hasContent = true;
    this.content = content;
  }
  public String getContent(){
    return content;
  }
  private boolean hasCreatetime;
  public boolean isHasCreatetime(){
    return hasCreatetime;
  }
  private boolean whereCreatetime;
  public boolean isWhereCreatetime(){
    return this.whereCreatetime;
  }
  public void setWhereCreatetime(boolean whereCreatetime){
    this.whereCreatetime = whereCreatetime;
  }
  private java.util.Date createtime;
  public void setCreatetime(java.util.Date createtime){
    this.hasCreatetime = true;
    this.createtime = createtime;
  }
  public java.util.Date getCreatetime(){
    return createtime;
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
