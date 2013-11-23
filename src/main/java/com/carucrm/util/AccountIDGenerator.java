package com.carucrm.util;

import com.common.db.DBAgentOO;

public class AccountIDGenerator {
	private int accountID = -1;
	private static AccountIDGenerator instance = new AccountIDGenerator();

	public static AccountIDGenerator getInstance() {
		return instance;
	}

	private AccountIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(id) from account");
			if (id == null || id.equals("")) {
				accountID = 0;
			} else {
				accountID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getId() {
		accountID++;
		return accountID;
	}
}
