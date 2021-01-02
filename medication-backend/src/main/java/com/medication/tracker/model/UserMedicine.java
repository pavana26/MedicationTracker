package com.medication.tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

/*
 * Author :Pavana
 * Version :1
 */

@Entity
@Table(name="usermedicine")
public class UserMedicine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_medicine_id")
	private Integer userMedicineId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="medicine_name")
	private String medicineName;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="instructions")
	private String instructions;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="dose")
	private String dose;
	
	@Column(name="frequency")
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

	public UserMedicine(Integer userId, String medicineName, Date startDate, Date endDate, String instructions,
			String amount, String dose, String frequency) {
		super();
		this.userId = userId;
		this.medicineName = medicineName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.instructions = instructions;
		this.amount = amount;
		this.dose = dose;
		this.frequency = frequency;
	}

	public UserMedicine() {
		super();
	
	}
	
	

}
