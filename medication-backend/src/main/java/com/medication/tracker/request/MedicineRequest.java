package com.medication.tracker.request;


/*
 * Author :Pavana
 * Version :1
 */
public class MedicineRequest {

	private String medicineName;		

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public MedicineRequest(String medicineName) {
		super();
		this.medicineName = medicineName;
	}

	public MedicineRequest() {
	
	}	
	
}
