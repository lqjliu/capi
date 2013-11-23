package com.caru.util;

import com.caru.db.DBAgentOO;

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
					.selectSingleValue("select max(carId) from car");
			if (id == null || id.equals("")) {
				carID = 0;
			} else {
				carID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getCarID() {
		carID++;
		return carID;
	}
}
