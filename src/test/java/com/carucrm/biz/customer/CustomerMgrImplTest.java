package com.carucrm.biz.customer;

import java.util.Date;

import com.carucrm.biz.consume.ConsumeIDBean;
import com.common.web.RequestContext;
import com.common.web.Token;

import junit.framework.TestCase;

public class CustomerMgrImplTest extends TestCase {

	public CustomerMgrImplTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetInstance() {
		CustomerMgrImpl customerMgrImpl = CustomerMgrImpl.getInstance();
	}

	public void testAddCustomer() {
		Token token = new Token();
		token.setAccountid(1);
		token.setContactid(1);
		token.setCorporationid(1);
		RequestContext.putToken(token);
		CustomerMgrImpl customerMgrImpl = CustomerMgrImpl.getInstance();
		CustomerBean customerBean = new CustomerBean();
		customerBean.setBrandid(1);
		customerBean.setCityid(2);
		customerBean.setGender(1);
		customerBean.setMobile("mobile3");
		customerBean.setModelid(1);
		customerBean.setName("Name");
		customerBean.setPlatenumber("PlateName");
		customerBean.setProvinceid(1);
		customerBean.setRegistrydate(new Date());
		customerBean.setRemark("remark");
		customerBean.setVendorid(2);
		try{
			CustomerResultBean result = customerMgrImpl.getInstance().addCustomer(customerBean);
			System.out.print(result);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


	public void testEditCustomer() {
		Token token = new Token();
		token.setAccountid(1);
		token.setContactid(1);
		token.setCorporationid(1);
		RequestContext.putToken(token);
		CustomerMgrImpl customerMgrImpl = CustomerMgrImpl.getInstance();
		CustomerBean customerBean = new CustomerBean();
		customerBean.setBrandid(3);
		customerBean.setCityid(3);
		customerBean.setGender(3);
		customerBean.setMobile("mobile3");
		customerBean.setModelid(3);
		customerBean.setName("Name3");
		customerBean.setPlatenumber("PlateName3");
		customerBean.setProvinceid(3);
		customerBean.setRegistrydate(new Date());
		customerBean.setRemark("remark3");
		customerBean.setVendorid(3);
		customerBean.setCustomerid(3);
		try{
			CustomerResultBean result = customerMgrImpl.getInstance().editCustomer(customerBean);
			System.out.print(result);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void testGetCustomer() {
		try{
			Token token = new Token();
			token.setAccountid(1);
			token.setContactid(1);
			token.setCorporationid(1);
			RequestContext.putToken(token);
			CustomerMgrImpl customerMgrImpl = CustomerMgrImpl.getInstance();
			ConsumeIDBean consumeIDBean = new ConsumeIDBean();
			consumeIDBean.setConsumeid(3);
			consumeIDBean.setCustomerid(24);
			CustomerBean result = customerMgrImpl.getCustomer(consumeIDBean);
			System.out.print(result);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void testDeleteCustomer() {
		try{
			Token token = new Token();
			token.setAccountid(1);
			token.setContactid(1);
			token.setCorporationid(1);
			RequestContext.putToken(token);
			CustomerMgrImpl customerMgrImpl = CustomerMgrImpl.getInstance();
			customerMgrImpl.deleteCustomer(3);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
