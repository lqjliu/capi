package com.carucrm.util;

import com.common.db.DBAgentOO;

public class CorporationIDGenerator {
	private int corporationID = -1;
	private static CorporationIDGenerator instance = new CorporationIDGenerator();

	public static CorporationIDGenerator getInstance() {
		return instance;
	}

	private CorporationIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(id) from corporation");
			if (id == null || id.equals("")) {
				corporationID = 0;
			} else {
				corporationID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getId() {
		corporationID++;
		return corporationID;
	}
}
