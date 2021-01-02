package com.medication.tracker.request;

import java.util.Date;

/*
 * Author :Pavana
 * Version :1
 */
public class SearchRequest {

	private Date fromDate;	
	
	private Date toDate;
	
	private String userId;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public SearchRequest(Date fromDate, Date toDate, String userId) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.userId = userId;
	}

	public SearchRequest() {
		
	}
	
}
