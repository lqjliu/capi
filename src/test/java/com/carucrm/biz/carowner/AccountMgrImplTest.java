package com.carucrm.biz.carowner;

import java.util.Date;

import com.carucrm.biz.NewResultBean;

import junit.framework.TestCase;

public class AccountMgrImplTest extends TestCase {

	public AccountMgrImplTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testVerifyCode() {
		try {
			VerificationCodeResultBean bean = AccountMgrImpl.getInstance().verifyCode("123456789");
			System.out.println("bean = " + bean);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testIsCarOwnerAccountNameDuplicated() {
		try {
			boolean result = AccountMgrImpl.getInstance().isCarOwnerAccountNameDuplicated("name1");
			System.out.println("result = " + result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testIsCarOwnerAccountEmailDuplicated() {
		try {
			boolean result = AccountMgrImpl.getInstance().isCarOwnerAccountEmailDuplicated("email1");
			System.out.println("result = " + result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testRegisterCarOwnerAccount() {
		try {
			AccountBean accountBean = new AccountBean();
			accountBean.setBrandid(1);
			accountBean.setCityid(1);
			accountBean.setCorporationid(6);
			accountBean.setCustomerid(1);
			accountBean.setEmail("email1");
			accountBean.setModelid(1);
			accountBean.setName("name1");
			accountBean.setPassword("password");
			accountBean.setProvinceid(1);
			accountBean.setRegistrydate(new Date());
			accountBean.setVendorid(1);
			NewResultBean bean = AccountMgrImpl.getInstance().registerCarOwnerAccount(accountBean);
			System.out.println("bean = " + bean);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
