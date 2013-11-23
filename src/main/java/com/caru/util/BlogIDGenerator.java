package com.caru.util;

import com.caru.db.DBAgentOO;

public class BlogIDGenerator {
	private int blogID = -1;
	private static BlogIDGenerator instance = new BlogIDGenerator();

	public static BlogIDGenerator getInstance() {
		return instance;
	}

	private BlogIDGenerator() {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			String id = dbAgentOO
					.selectSingleValue("select max(blogID) from cyblog");
			if (id == null || id.equals("")) {
				blogID = 0;
			} else {
				blogID = Integer.parseInt(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized int getBlogID() {
		blogID++;
		return blogID;
	}
}


