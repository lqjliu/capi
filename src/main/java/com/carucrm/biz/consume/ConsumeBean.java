package com.carucrm.biz.consume;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsumeBean {
	private int consumeid;
	
	public int getConsumeid() {
		return consumeid;
	}
	public void setConsumeid(int consumeid) {
		this.consumeid = consumeid;
	}
	private Date indate;
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public int getOdometer() {
		return odometer;
	}
	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}
	public String getPhoenoment() {
		return phoenoment;
	}
	public void setPhoenoment(String phoenoment) {
		this.phoenoment = phoenoment;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSupportrepair() {
		return supportrepair;
	}
	public void setSupportrepair(int supportrepair) {
		this.supportrepair = supportrepair;
	}
	public int getSupportmaintain() {
		return supportmaintain;
	}
	public void setSupportmaintain(int supportmaintain) {
		this.supportmaintain = supportmaintain;
	}
	public int getSupportwashing() {
		return supportwashing;
	}
	public void setSupportwashing(int supportwashing) {
		this.supportwashing = supportwashing;
	}
	public int getSupportdecorate() {
		return supportdecorate;
	}
	public void setSupportdecorate(int supportdecorate) {
		this.supportdecorate = supportdecorate;
	}
	public int getSupportinsuranceconsult() {
		return supportinsuranceconsult;
	}
	public void setSupportinsuranceconsult(int supportinsuranceconsult) {
		this.supportinsuranceconsult = supportinsuranceconsult;
	}
	public int getSupportnewcarregister() {
		return supportnewcarregister;
	}
	public void setSupportnewcarregister(int supportnewcarregister) {
		this.supportnewcarregister = supportnewcarregister;
	}
	public int getSupportcrossplaceregister() {
		return supportcrossplaceregister;
	}
	public void setSupportcrossplaceregister(int supportcrossplaceregister) {
		this.supportcrossplaceregister = supportcrossplaceregister;
	}
	public int getSupport2handexchange() {
		return support2handexchange;
	}
	public void setSupport2handexchange(int support2handexchange) {
		this.support2handexchange = support2handexchange;
	}
	public double getMaterialfee() {
		return materialfee;
	}
	public void setMaterialfee(double materialfee) {
		this.materialfee = materialfee;
	}
	public double getOutsourcingfee() {
		return outsourcingfee;
	}
	public void setOutsourcingfee(double outsourcingfee) {
		this.outsourcingfee = outsourcingfee;
	}
	public double getManagementfee() {
		return managementfee;
	}
	public void setManagementfee(double managementfee) {
		this.managementfee = managementfee;
	}
	public double getDragfee() {
		return dragfee;
	}
	public void setDragfee(double dragfee) {
		this.dragfee = dragfee;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getOtherfee() {
		return otherfee;
	}
	public void setOtherfee(double otherfee) {
		this.otherfee = otherfee;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	public double getCalculatedmoney() {
		return calculatedmoney;
	}
	public void setCalculatedmoney(double calculatedmoney) {
		this.calculatedmoney = calculatedmoney;
	}
	public double getActualmoney() {
		return actualmoney;
	}
	public void setActualmoney(double actualmoney) {
		this.actualmoney = actualmoney;
	}
	public double getDiscountmoney() {
		return discountmoney;
	}
	public void setDiscountmoney(double discountmoney) {
		this.discountmoney = discountmoney;
	}
	public Date getPaiddate() {
		return paiddate;
	}
	public void setPaiddate(Date paiddate) {
		this.paiddate = paiddate;
	}
	public String getInternalremark() {
		return internalremark;
	}
	public void setInternalremark(String internalremark) {
		this.internalremark = internalremark;
	}
	private int customerid;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	private int odometer;
	private String solution;
	private String remark;
	private String phoenoment;
	private int supportrepair;
	private int supportmaintain;
	private int supportwashing;
	private int supportdecorate;
	private int supportinsuranceconsult;
	private int supportnewcarregister;
	private int supportcrossplaceregister;
	private int support2handexchange;
	private double materialfee;
	private double materialgapfee;
	public double getMaterialgapfee() {
		return materialgapfee;
	}
	public void setMaterialgapfee(double materialgapfee) {
		this.materialgapfee = materialgapfee;
	}
	private double outsourcingfee;
	private double managementfee;
	private double dragfee;
	private double tax;
	private double otherfee;
	private Date outdate;
	private double calculatedmoney;
	private double actualmoney;
	private double discountmoney;
	private Date paiddate;
	private String internalremark;
	
	private List<ConsumeitemBean> consumeitems= new ArrayList<ConsumeitemBean>();
	public List<ConsumeitemBean> getConsumeitems() {
		return consumeitems;
	}
	public void setConsumeitems(List<ConsumeitemBean> consumeitems) {
		this.consumeitems = consumeitems;
	}
	
	private String customerplatenumber;
	public String getCustomerplatenumber() {
		return customerplatenumber;
	}
	public void setCustomerplatenumber(String customerplatenumber) {
		this.customerplatenumber = customerplatenumber;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomermobile() {
		return customermobile;
	}
	public void setCustomermobile(String customermobile) {
		this.customermobile = customermobile;
	}
	private String customername;
	private String customermobile;
}
