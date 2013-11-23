/**
 * 
 */
package com.carucrm.biz.register;

import java.util.Random;

import junit.framework.TestCase;

/**
 * @author robin
 *
 */
public class RegisterMgrImplTest extends TestCase {

	/**
	 * @param name
	 */
	public RegisterMgrImplTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.carucrm.biz.register.RegisterMgrImpl#isSymbolDuplicated(java.lang.String)}.
	 */
	public void testIsSymbolDuplicated() {
		try{
			int randomfee = getRandomInt();
			boolean result = RegisterMgrImpl.getInstance().isSymbolDuplicated("Symbol" + randomfee);
		}catch(Exception ex){
			fail("Fail in exception : " + ex.getMessage());
		}
	}

	/**
	 * Test method for {@link com.carucrm.biz.register.RegisterMgrImpl#isContactMobileDuplicated(java.lang.String)}.
	 */
	public void testIsContactMobileDuplicated() {
		try{
			int randomfee = getRandomInt();
			boolean result = RegisterMgrImpl.getInstance().isContactMobileDuplicated("ContactMobile" + randomfee);
		}catch(Exception ex){
			fail("Fail in exception : " + ex.getMessage());
		}
	}

	/**
	 * Test method for {@link com.carucrm.biz.register.RegisterMgrImpl#isAccountNameDuplicated(java.lang.String)}.
	 */
	public void testIsAccountNameDuplicated() {
		try{
			int randomfee = getRandomInt();
			boolean result = RegisterMgrImpl.getInstance().isAccountNameDuplicated("AccountName" + randomfee);
		}catch(Exception ex){
			fail("Fail in exception : " + ex.getMessage());
		}
	}

	/**
	 * Test method for {@link com.carucrm.biz.register.RegisterMgrImpl#isAccountEmailDuplicated(java.lang.String)}.
	 */
	public void testIsAccountEmailDuplicated() {
		try{
			int randomfee = getRandomInt();
			boolean result = RegisterMgrImpl.getInstance().isAccountEmailDuplicated("AccountEmail" + randomfee);
		}catch(Exception ex){
			fail("Fail in exception : " + ex.getMessage());
		}
	}

	/**
	 * Test method for {@link com.carucrm.biz.register.RegisterMgrImpl#isAccountContactMobileDuplicated(java.lang.String)}.
	 */
	public void testIsAccountContactMobileDuplicated() {
		try{
			int randomfee = getRandomInt();
			boolean result = RegisterMgrImpl.getInstance().isAccountNameDuplicated("AccountContactMobile" + randomfee);
		}catch(Exception ex){
			fail("Fail in exception : " + ex.getMessage());
		}
	}

	/**
	 * Test method for {@link com.carucrm.biz.register.RegisterMgrImpl#registerCorporation(com.carucrm.biz.register.CorporationRegisterBean)}.
	 */
	public void testRegisterCorporation() {
		CorporationRegisterBean register = getMinCorporationRegisterBean();
		try{
			CorporationRegisterResultBean result = RegisterMgrImpl.getInstance().registerCorporation(register);
			register = getMaxCorporationRegisterBean();
			result = RegisterMgrImpl.getInstance().registerCorporation(register);
		}catch(Exception ex){
			fail("Fail in exception : " + ex.getMessage());
		}
	}
	
	public int getRandomInt(){
		Random random = new Random(); 
		int result = random.nextInt();
		return result;
	}
	
	public CorporationRegisterBean getMinCorporationRegisterBean(){
		int randomfee = getRandomInt();
		CorporationRegisterBean register = new CorporationRegisterBean();
		register.setSymbol("Symbol" + randomfee);
		register.setName("Name" + randomfee);
		register.setContactname("Contactname" + randomfee);
		register.setContactmobile("Contactmobile" + randomfee);
		register.setAccountcontactname("Accountcontactname" + randomfee);
		register.setAccountcontactmobile("Accountcontactmobile" + randomfee);
		register.setAccountemail("Accountemail" + randomfee);
		register.setAccountname("Accountname" + randomfee);
		register.setAccountpassword("Accountpassword" + randomfee);
		return register;
	}
	
	public CorporationRegisterBean getMaxCorporationRegisterBean(){
		int randomfee = getRandomInt();
		CorporationRegisterBean register = new CorporationRegisterBean();
		register.setSymbol("Symbol" + randomfee);
		register.setName("Name" + randomfee);
		register.setSupportrepair(1);
		register.setSupportmaintain(1);
		register.setSupportwashing(1);
		register.setSupport2handexchange(1);
		register.setSupportcrossplaceregister(1);
		register.setSupportdecorate(1);
		register.setSupportinsuranceconsult(1);
		register.setSupportnewcarregister(1);
		register.setProvinceid(randomfee);
		register.setCityid(randomfee);
		register.setCountyid(randomfee);
		register.setAddress("Address" + randomfee);
		register.setPlatenumberprefix("P" + randomfee);
		register.setContactname("Contactname" + randomfee);
		register.setContactmobile("Contactmobile" + randomfee);
		register.setCsphone1("P1" + randomfee);
		register.setCsphone1areacode("A1" + randomfee);
		register.setCsphone2("P2" + randomfee);
		register.setCsphone2areacode("A2" + randomfee);
		register.setAccountname("Accountname" + randomfee);
		register.setAccountemail("Accountemail" + randomfee);
		register.setAccountpassword("Accountpassword" + randomfee);
		register.setAccountcontactname("Accountcontactname" + randomfee);
		register.setAccountcontactmobile("Accountcontactmobile" + randomfee);
		return register;
	}	
	

}
