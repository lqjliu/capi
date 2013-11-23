package com.carucrm.util;

import com.common.db.DBAgentOO;

public class ContactIDGenerator {
	private int contactID = -1;
	private static ContactIDGenerator instance = new ContactIDGenerator();

	public static ContactIDGenerator getInstance() {
		return instance;
	}

	private ContactIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(id) from contact");
			if (id == null || id.equals("")) {
				contactID = 0;
			} else {
				contactID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getId() {
		contactID++;
		return contactID;
	}
}
