package com.medication.tracker.request;

/*
 * Author :Pavana
 * Version :1
 */
public class UserRequest {

	private String userName;	
	
	private String password;	
	
	private String email;
	
	private String phone;
	
	private String address;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public UserRequest() {
	
	}

	public UserRequest(String userName, String password, String email, String phone, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}	
	
}
