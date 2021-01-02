package com.medication.tracker.response;

import java.util.List;

/*
 * Author :Pavana
 * Version :1
 */
public class UserMedicineSearchResponse {	
	
	private  List<UserMedicineItem> userMedicineList;

	public List<UserMedicineItem> getUserMedicineList() {
		return userMedicineList;
	}

	public void setUserMedicineList(List<UserMedicineItem> userMedicineList) {
		this.userMedicineList = userMedicineList;
	}
	
}
