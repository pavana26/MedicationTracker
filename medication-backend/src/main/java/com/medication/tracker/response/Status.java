package com.medication.tracker.response;


/*
 * Author :Pavana
 * Version :1
 */
public class Status {	
	
	
	private String message;	
	
	private String id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Status() {

	}

	public Status(String message, String id) {
		super();
		this.message = message;
		this.id = id;
	}

}
