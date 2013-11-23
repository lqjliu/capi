package com.carucrm.biz.customer;

import java.util.ArrayList;
import java.util.List;

public class SuggestCustomerResultBean {
	
	private int suggestKeywordType;
	public int getSuggestKeywordType() {
		return suggestKeywordType;
	}
	public void setSuggestKeywordType(int suggestKeywordType) {
		this.suggestKeywordType = suggestKeywordType;
	}
	private List<SuggestCustomerBean> suggestCustomerList = new ArrayList<SuggestCustomerBean>();
	public List<SuggestCustomerBean> getSuggestCustomerList() {
		return suggestCustomerList;
	}
	public void setSuggestCustomerList(List<SuggestCustomerBean> suggestCustomerList) {
		this.suggestCustomerList = suggestCustomerList;
	}
}
