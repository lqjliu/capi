package com.carucrm.biz.carowner;

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

	public void testListCarOwnerConsume() {
		Token token = new Token();
		token.setAccountid(12);
		token.setContactid(18);
		RequestContext.putToken(token);
		ConsumeListConditionBean consumeListConditionBean = new ConsumeListConditionBean();
		try {
			ConsumeListResultBean listResultBean = ConsumeMgrImpl.getInstance().listCarOwnerConsume(
					consumeListConditionBean);
			System.out.println("listResultBean = " + listResultBean);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
