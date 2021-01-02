package com.medication.tracker.response;

import java.util.Date;
/*
 * Author :Pavana
 * Version :1
 */

public class UserMedicineResponse {	
	
	private Integer userMedicineId;

	private Integer userId;
	
	private String medicineName;

	private Date startDate;	

	private Date endDate;	
	
	private String instructions;
	
	private String dose;
	
	private String amount;
	
	private String frequency;

	public Integer getUserMedicineId() {
		return userMedicineId;
	}

	public void setUserMedicineId(Integer userMedicineId) {
		this.userMedicineId = userMedicineId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	} 
	
	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


	public UserMedicineResponse(Integer userMedicineId, Integer userId, String medicineName, Date startDate,
			Date endDate, String instructions, String dose, String amount, String frequency) {
		super();
		this.userMedicineId = userMedicineId;
		this.userId = userId;
		this.medicineName = medicineName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructions = instructions;
		this.dose = dose;
		this.amount = amount;
		this.frequency = frequency;
	}

	public UserMedicineResponse() {
		super();
	
	}
	

}
