package com.caru.util;

import com.caru.db.DBAgentOO;

public class FeeIDGenerator {
	private int feeID = -1;
	private static FeeIDGenerator instance = new FeeIDGenerator();

	public static FeeIDGenerator getInstance() {
		return instance;
	}

	private FeeIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(feeID) from fee");
			if (id == null || id.equals("")) {
				feeID = 0;
			} else {
				feeID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getFeeID() {
		feeID++;
		return feeID;
	}
}
