package com.caru.util;

import com.caru.db.DBAgentOO;

public class UserIDGenerator {
	private int userID = -1;
	private static UserIDGenerator instance = new UserIDGenerator();

	public static UserIDGenerator getInstance() {
		return instance;
	}

	private UserIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(userId) from user");
			if (id == null || id.equals("")) {
				userID = 0;
			} else {
				userID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getUserID() {
		userID++;
		return userID;
	}
}
