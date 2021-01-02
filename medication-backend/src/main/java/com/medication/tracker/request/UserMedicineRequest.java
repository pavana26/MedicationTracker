package com.medication.tracker.request;

import java.util.Date;

/*
 * Author :Pavana
 * Version :1
 */
public class UserMedicineRequest {
		
	private String medicineName;	
	
	private Date fromDate;	
	
	private Date toDate;	
	
	private String instructions;
	
	private String amount;
	
	private String dose;
	
	private String frequency;
	

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

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

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public UserMedicineRequest(String medicineName, Date fromDate, Date toDate, String instructions, String amount,
			String dose, String frequency) {
		super();
		this.medicineName = medicineName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.instructions = instructions;
		this.amount = amount;
		this.dose = dose;
		this.frequency = frequency;
	}

	public UserMedicineRequest() {
		super();
	
	}
	
	

}
