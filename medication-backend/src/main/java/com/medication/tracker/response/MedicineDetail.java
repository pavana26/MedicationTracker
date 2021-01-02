package com.medication.tracker.response;


/*
 * Author :Pavana
 * Version :1
 */
public class MedicineDetail {	

	private Integer usermedicineId; 
	
	private String medicineName;
	
	private String instructions;
	
	private String amount;
	
	private String dose;
	
	private String frequency;
	
	public Integer getUsermedicineId() {
		return usermedicineId;
	}

	public void setUsermedicineId(Integer usermedicineId) {
		this.usermedicineId = usermedicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
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

	
	public MedicineDetail(String medicineName, String instructions, String amount, String dose, String frequency) {
		super();
		this.medicineName = medicineName;
		this.instructions = instructions;
		this.amount = amount;
		this.dose = dose;
		this.frequency = frequency;
	}

	public MedicineDetail() {
		super();
	
	}
	
	

}
