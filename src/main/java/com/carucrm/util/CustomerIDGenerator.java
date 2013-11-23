package com.carucrm.util;

import com.common.db.DBAgentOO;

public class CustomerIDGenerator {
	private int customerID = -1;
	private static CustomerIDGenerator instance = new CustomerIDGenerator();

	public static CustomerIDGenerator getInstance() {
		return instance;
	}

	private CustomerIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(id) from customer");
			if (id == null || id.equals("")) {
				customerID = 0;
			} else {
				customerID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getId() {
		customerID++;
		return customerID;
	}
}
