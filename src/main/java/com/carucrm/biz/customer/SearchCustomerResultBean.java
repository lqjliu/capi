package com.carucrm.biz.customer;

import java.util.ArrayList;
import java.util.List;

public class SearchCustomerResultBean {

	
	private List<SearchCustomerBean> searchCustomerList = new ArrayList<SearchCustomerBean>();
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
	
	public List<SearchCustomerBean> getSearchCustomerList() {
		return searchCustomerList;
	}

	public void setSearchCustomerList(List<SearchCustomerBean> searchCustomerList) {
		this.searchCustomerList = searchCustomerList;
	}
}
