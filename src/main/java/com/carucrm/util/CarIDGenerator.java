package com.carucrm.util;

import com.common.db.DBAgentOO;

public class CarIDGenerator {
	private int carID = -1;
	private static CarIDGenerator instance = new CarIDGenerator();

	public static CarIDGenerator getInstance() {
		return instance;
	}

	private CarIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(id) from car");
			if (id == null || id.equals("")) {
				carID = 0;
			} else {
				carID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getId() {
		carID++;
		return carID;
	}
}
