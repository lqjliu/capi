package com.carucrm.biz.consume;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.common.web.RequestContext;
import com.common.web.Token;

import junit.framework.TestCase;

public class ConsumeMgrImplTest extends TestCase {

	public ConsumeMgrImplTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetInstance() {
		// fail("Not yet implemented");
	}

	public void ktestAddConsume() {
		Token token = new Token();
		token.setAccountid(1);
		token.setContactid(1);
		token.setCorporationid(6);
		RequestContext.putToken(token);
		ConsumeBean consumeBean = new ConsumeBean();
		consumeBean.setActualmoney(100);
		consumeBean.setCalculatedmoney(200);
		consumeBean.setDiscountmoney(300);
		consumeBean.setDragfee(400);
		consumeBean.setIndate(new Date());
		consumeBean.setInternalremark("internalremark");
		consumeBean.setManagementfee(500);
		consumeBean.setMaterialfee(600);
		consumeBean.setOdometer(1000);
		consumeBean.setOtherfee(700);
		consumeBean.setOutdate(new Date());
		consumeBean.setOutsourcingfee(800);
		consumeBean.setPhoenoment("Phoenoment");
		consumeBean.setRemark("remark");
		consumeBean.setSolution("solution");
		consumeBean.setTax(900);
		consumeBean.setCustomerid(24);
		consumeBean.setPaiddate(new Date());
		consumeBean.setSupport2handexchange(1);

		ConsumeitemBean consumeitemBean = new ConsumeitemBean();
		consumeitemBean.setAmount(100);
		consumeitemBean.setMoney(200);
		consumeitemBean.setName("nameitem");
		consumeitemBean.setPrice(50);
		consumeitemBean.setRemark("remark");
		consumeitemBean.setType(1);
		consumeitemBean.setUnit("unit");

		List<ConsumeitemBean> list = new ArrayList<ConsumeitemBean>();
		list.add(consumeitemBean);
		consumeitemBean = new ConsumeitemBean();
		consumeitemBean.setAmount(100);
		consumeitemBean.setMoney(200);
		consumeitemBean.setName("nameitem");
		consumeitemBean.setPrice(50);
		consumeitemBean.setRemark("remark");
		consumeitemBean.setType(1);
		consumeitemBean.setUnit("u");
		list.add(consumeitemBean);
		consumeBean.setConsumeitems(list);

		try {
			ConsumeMgrImpl.getInstance().addConsume(consumeBean);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	public void ktestEditConsume() {
		Token token = new Token();
		token.setAccountid(1);
		token.setContactid(1);
		token.setCorporationid(6);
		RequestContext.putToken(token);
		ConsumeBean consumeBean = new ConsumeBean();
		consumeBean.setActualmoney(100);
		consumeBean.setCalculatedmoney(200);
		consumeBean.setDiscountmoney(300);
		consumeBean.setDragfee(400);
		consumeBean.setIndate(new Date());
		consumeBean.setInternalremark("qqqqq");
		consumeBean.setManagementfee(500);
		consumeBean.setMaterialfee(600);
		consumeBean.setOdometer(1000);
		consumeBean.setOtherfee(700);
		consumeBean.setOutdate(new Date());
		consumeBean.setOutsourcingfee(800);
		consumeBean.setPhoenoment("pppppp");
		consumeBean.setRemark("ssssss");
		consumeBean.setSolution("tttttt");
		consumeBean.setTax(900);
		consumeBean.setCustomerid(24);
		consumeBean.setPaiddate(new Date());
		consumeBean.setSupport2handexchange(1);
		consumeBean.setConsumeid(3);

		ConsumeitemBean consumeitemBean = new ConsumeitemBean();
		consumeitemBean.setAmount(100);
		consumeitemBean.setMoney(200);
		consumeitemBean.setName("kkkkkk");
		consumeitemBean.setPrice(50);
		consumeitemBean.setRemark("bbbbb");
		consumeitemBean.setType(1);
		consumeitemBean.setUnit("cccc");

		List<ConsumeitemBean> list = new ArrayList<ConsumeitemBean>();
		list.add(consumeitemBean);
		consumeitemBean = new ConsumeitemBean();
		consumeitemBean.setAmount(100);
		consumeitemBean.setMoney(200);
		consumeitemBean.setName("aaaaaaaa");
		consumeitemBean.setPrice(50);
		consumeitemBean.setRemark("bbbbb");
		consumeitemBean.setType(1);
		consumeitemBean.setUnit("cccc");
		list.add(consumeitemBean);
		consumeBean.setConsumeitems(list);

		try {
			ConsumeMgrImpl.getInstance().editConsume(consumeBean);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void ktestGetConsume() {
		Token token = new Token();
		token.setAccountid(1);
		token.setContactid(1);
		token.setCorporationid(6);
		RequestContext.putToken(token);
		ConsumeIDBean consumeIDBean = new ConsumeIDBean();
		consumeIDBean.setCustomerid(24);
		consumeIDBean.setConsumeid(6);

		try {
			ConsumeBean consumeBean = ConsumeMgrImpl.getInstance().getConsume(consumeIDBean);
			System.out.println("consumeBean = " + consumeBean);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void atestDeleteConsume() {
		Token token = new Token();
		token.setAccountid(1);
		token.setContactid(1);
		token.setCorporationid(6);
		RequestContext.putToken(token);
		ConsumeIDBean consumeIDBean = new ConsumeIDBean();
		consumeIDBean.setCustomerid(24);
		consumeIDBean.setConsumeid(6);

		try {
			ConsumeMgrImpl.getInstance().deleteConsume(consumeIDBean);
			System.out.println("consumeBean = " + consumeIDBean);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

		
		public void testListConsume1() {
			Token token = new Token();
			token.setAccountid(1);
			token.setContactid(1);
			token.setCorporationid(6);
			RequestContext.putToken(token);
			ConsumeListConditionBean consumeListConditionBean = new ConsumeListConditionBean();
			try {
				ConsumeListResultBean1 result = ConsumeMgrImpl.getInstance().listConsume1(consumeListConditionBean);
				System.out.println("consumeBean = " + result.getListconsume1().size());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}

}
