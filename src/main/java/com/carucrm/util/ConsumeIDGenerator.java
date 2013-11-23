package com.carucrm.util;

import com.common.db.DBAgentOO;

public class ConsumeIDGenerator {
	private int consumeID = -1;
	private static ConsumeIDGenerator instance = new ConsumeIDGenerator();

	public static ConsumeIDGenerator getInstance() {
		return instance;
	}

	private ConsumeIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(id) from consume");
			if (id == null || id.equals("")) {
				consumeID = 0;
			} else {
				consumeID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getId() {
		consumeID++;
		return consumeID;
	}
}
