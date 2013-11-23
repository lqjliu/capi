package com.caru.util;

import com.caru.db.DBAgentOO;

public class RoadBookIDGenerator {
	private int roadBookID = -1;
	private static RoadBookIDGenerator instance = new RoadBookIDGenerator();

	public static RoadBookIDGenerator getInstance() {
		return instance;
	}

	private RoadBookIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(roadbookid) from cyroadbook");
			if (id == null || id.equals("")) {
				roadBookID = 0;
			} else {
				roadBookID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getRoadBookID() {
		roadBookID++;
		return roadBookID;
	}
}
