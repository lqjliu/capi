package com.carucrm.biz.carowner;

import java.util.ArrayList;
import java.util.List;

public class ConsumeListResultBean {
	private int pagesize;
	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getCurrentpageno() {
		return currentpageno;
	}

	public void setCurrentpageno(int currentpageno) {
		this.currentpageno = currentpageno;
	}
	private int currentpageno;
	
	private List carownerconsume = new ArrayList();
	public List getCarownerconsume() {
		return carownerconsume;
	}

	public void setCarownerconsume(List carownerconsume) {
		this.carownerconsume = carownerconsume;
	}
	
}
