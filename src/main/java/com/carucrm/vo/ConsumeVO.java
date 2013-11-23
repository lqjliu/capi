package com.carucrm.vo;

public class ConsumeVO implements java.io.Serializable{
  public static final String TABLE_NAME = "consume";
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
  private boolean hasConsumeserialno;
  public boolean isHasConsumeserialno(){
    return hasConsumeserialno;
  }
  private boolean whereConsumeserialno;
  public boolean isWhereConsumeserialno(){
    return this.whereConsumeserialno;
  }
  public void setWhereConsumeserialno(boolean whereConsumeserialno){
    this.whereConsumeserialno = whereConsumeserialno;
  }
  private String consumeserialno;
  public void setConsumeserialno(String consumeserialno){
    this.hasConsumeserialno = true;
    this.consumeserialno = consumeserialno;
  }
  public String getConsumeserialno(){
    return consumeserialno;
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
  private boolean hasCustomerid;
  public boolean isHasCustomerid(){
    return hasCustomerid;
  }
  private boolean whereCustomerid;
  public boolean isWhereCustomerid(){
    return this.whereCustomerid;
  }
  public void setWhereCustomerid(boolean whereCustomerid){
    this.whereCustomerid = whereCustomerid;
  }
  private int customerid;
  public void setCustomerid(int customerid){
    this.hasCustomerid = true;
    this.customerid = customerid;
  }
  public int getCustomerid(){
    return customerid;
  }
  private boolean hasIndate;
  public boolean isHasIndate(){
    return hasIndate;
  }
  private boolean whereIndate;
  public boolean isWhereIndate(){
    return this.whereIndate;
  }
  public void setWhereIndate(boolean whereIndate){
    this.whereIndate = whereIndate;
  }
  private java.util.Date indate;
  public void setIndate(java.util.Date indate){
    this.hasIndate = true;
    this.indate = indate;
  }
  public java.util.Date getIndate(){
    return indate;
  }
  private boolean hasOdometer;
  public boolean isHasOdometer(){
    return hasOdometer;
  }
  private boolean whereOdometer;
  public boolean isWhereOdometer(){
    return this.whereOdometer;
  }
  public void setWhereOdometer(boolean whereOdometer){
    this.whereOdometer = whereOdometer;
  }
  private int odometer;
  public void setOdometer(int odometer){
    this.hasOdometer = true;
    this.odometer = odometer;
  }
  public int getOdometer(){
    return odometer;
  }
  private boolean hasPhoenoment;
  public boolean isHasPhoenoment(){
    return hasPhoenoment;
  }
  private boolean wherePhoenoment;
  public boolean isWherePhoenoment(){
    return this.wherePhoenoment;
  }
  public void setWherePhoenoment(boolean wherePhoenoment){
    this.wherePhoenoment = wherePhoenoment;
  }
  private String phoenoment;
  public void setPhoenoment(String phoenoment){
    this.hasPhoenoment = true;
    this.phoenoment = phoenoment;
  }
  public String getPhoenoment(){
    return phoenoment;
  }
  private boolean hasSolution;
  public boolean isHasSolution(){
    return hasSolution;
  }
  private boolean whereSolution;
  public boolean isWhereSolution(){
    return this.whereSolution;
  }
  public void setWhereSolution(boolean whereSolution){
    this.whereSolution = whereSolution;
  }
  private String solution;
  public void setSolution(String solution){
    this.hasSolution = true;
    this.solution = solution;
  }
  public String getSolution(){
    return solution;
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
  private boolean hasMaterialfee;
  public boolean isHasMaterialfee(){
    return hasMaterialfee;
  }
  private boolean whereMaterialfee;
  public boolean isWhereMaterialfee(){
    return this.whereMaterialfee;
  }
  public void setWhereMaterialfee(boolean whereMaterialfee){
    this.whereMaterialfee = whereMaterialfee;
  }
  private double materialfee;
  public void setMaterialfee(double materialfee){
    this.hasMaterialfee = true;
    this.materialfee = materialfee;
  }
  public double getMaterialfee(){
    return materialfee;
  }
  private boolean hasMaterialgapfee;
  public boolean isHasMaterialgapfee(){
    return hasMaterialgapfee;
  }
  private boolean whereMaterialgapfee;
  public boolean isWhereMaterialgapfee(){
    return this.whereMaterialgapfee;
  }
  public void setWhereMaterialgapfee(boolean whereMaterialgapfee){
    this.whereMaterialgapfee = whereMaterialgapfee;
  }
  private double materialgapfee;
  public void setMaterialgapfee(double materialgapfee){
    this.hasMaterialgapfee = true;
    this.materialgapfee = materialgapfee;
  }
  public double getMaterialgapfee(){
    return materialgapfee;
  }
  private boolean hasOutsourcingfee;
  public boolean isHasOutsourcingfee(){
    return hasOutsourcingfee;
  }
  private boolean whereOutsourcingfee;
  public boolean isWhereOutsourcingfee(){
    return this.whereOutsourcingfee;
  }
  public void setWhereOutsourcingfee(boolean whereOutsourcingfee){
    this.whereOutsourcingfee = whereOutsourcingfee;
  }
  private double outsourcingfee;
  public void setOutsourcingfee(double outsourcingfee){
    this.hasOutsourcingfee = true;
    this.outsourcingfee = outsourcingfee;
  }
  public double getOutsourcingfee(){
    return outsourcingfee;
  }
  private boolean hasManagementfee;
  public boolean isHasManagementfee(){
    return hasManagementfee;
  }
  private boolean whereManagementfee;
  public boolean isWhereManagementfee(){
    return this.whereManagementfee;
  }
  public void setWhereManagementfee(boolean whereManagementfee){
    this.whereManagementfee = whereManagementfee;
  }
  private double managementfee;
  public void setManagementfee(double managementfee){
    this.hasManagementfee = true;
    this.managementfee = managementfee;
  }
  public double getManagementfee(){
    return managementfee;
  }
  private boolean hasDragfee;
  public boolean isHasDragfee(){
    return hasDragfee;
  }
  private boolean whereDragfee;
  public boolean isWhereDragfee(){
    return this.whereDragfee;
  }
  public void setWhereDragfee(boolean whereDragfee){
    this.whereDragfee = whereDragfee;
  }
  private double dragfee;
  public void setDragfee(double dragfee){
    this.hasDragfee = true;
    this.dragfee = dragfee;
  }
  public double getDragfee(){
    return dragfee;
  }
  private boolean hasTax;
  public boolean isHasTax(){
    return hasTax;
  }
  private boolean whereTax;
  public boolean isWhereTax(){
    return this.whereTax;
  }
  public void setWhereTax(boolean whereTax){
    this.whereTax = whereTax;
  }
  private double tax;
  public void setTax(double tax){
    this.hasTax = true;
    this.tax = tax;
  }
  public double getTax(){
    return tax;
  }
  private boolean hasOtherfee;
  public boolean isHasOtherfee(){
    return hasOtherfee;
  }
  private boolean whereOtherfee;
  public boolean isWhereOtherfee(){
    return this.whereOtherfee;
  }
  public void setWhereOtherfee(boolean whereOtherfee){
    this.whereOtherfee = whereOtherfee;
  }
  private double otherfee;
  public void setOtherfee(double otherfee){
    this.hasOtherfee = true;
    this.otherfee = otherfee;
  }
  public double getOtherfee(){
    return otherfee;
  }
  private boolean hasOutdate;
  public boolean isHasOutdate(){
    return hasOutdate;
  }
  private boolean whereOutdate;
  public boolean isWhereOutdate(){
    return this.whereOutdate;
  }
  public void setWhereOutdate(boolean whereOutdate){
    this.whereOutdate = whereOutdate;
  }
  private java.util.Date outdate;
  public void setOutdate(java.util.Date outdate){
    this.hasOutdate = true;
    this.outdate = outdate;
  }
  public java.util.Date getOutdate(){
    return outdate;
  }
  private boolean hasCalculatedmoney;
  public boolean isHasCalculatedmoney(){
    return hasCalculatedmoney;
  }
  private boolean whereCalculatedmoney;
  public boolean isWhereCalculatedmoney(){
    return this.whereCalculatedmoney;
  }
  public void setWhereCalculatedmoney(boolean whereCalculatedmoney){
    this.whereCalculatedmoney = whereCalculatedmoney;
  }
  private double calculatedmoney;
  public void setCalculatedmoney(double calculatedmoney){
    this.hasCalculatedmoney = true;
    this.calculatedmoney = calculatedmoney;
  }
  public double getCalculatedmoney(){
    return calculatedmoney;
  }
  private boolean hasActualmoney;
  public boolean isHasActualmoney(){
    return hasActualmoney;
  }
  private boolean whereActualmoney;
  public boolean isWhereActualmoney(){
    return this.whereActualmoney;
  }
  public void setWhereActualmoney(boolean whereActualmoney){
    this.whereActualmoney = whereActualmoney;
  }
  private double actualmoney;
  public void setActualmoney(double actualmoney){
    this.hasActualmoney = true;
    this.actualmoney = actualmoney;
  }
  public double getActualmoney(){
    return actualmoney;
  }
  private boolean hasDiscountmoney;
  public boolean isHasDiscountmoney(){
    return hasDiscountmoney;
  }
  private boolean whereDiscountmoney;
  public boolean isWhereDiscountmoney(){
    return this.whereDiscountmoney;
  }
  public void setWhereDiscountmoney(boolean whereDiscountmoney){
    this.whereDiscountmoney = whereDiscountmoney;
  }
  private double discountmoney;
  public void setDiscountmoney(double discountmoney){
    this.hasDiscountmoney = true;
    this.discountmoney = discountmoney;
  }
  public double getDiscountmoney(){
    return discountmoney;
  }
  private boolean hasPaiddate;
  public boolean isHasPaiddate(){
    return hasPaiddate;
  }
  private boolean wherePaiddate;
  public boolean isWherePaiddate(){
    return this.wherePaiddate;
  }
  public void setWherePaiddate(boolean wherePaiddate){
    this.wherePaiddate = wherePaiddate;
  }
  private java.util.Date paiddate;
  public void setPaiddate(java.util.Date paiddate){
    this.hasPaiddate = true;
    this.paiddate = paiddate;
  }
  public java.util.Date getPaiddate(){
    return paiddate;
  }
  private boolean hasInternalremark;
  public boolean isHasInternalremark(){
    return hasInternalremark;
  }
  private boolean whereInternalremark;
  public boolean isWhereInternalremark(){
    return this.whereInternalremark;
  }
  public void setWhereInternalremark(boolean whereInternalremark){
    this.whereInternalremark = whereInternalremark;
  }
  private String internalremark;
  public void setInternalremark(String internalremark){
    this.hasInternalremark = true;
    this.internalremark = internalremark;
  }
  public String getInternalremark(){
    return internalremark;
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
