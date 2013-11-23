package com.carucrm.biz.consume;

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
	
	private List listconsume = new ArrayList();
	public List getListconsume() {
		return listconsume;
	}

	public void setListconsume(List listconsume) {
		this.listconsume = listconsume;
	}

}
