package com.medication.tracker.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

/*
 * Author :Pavana
 * Version :1
 */
@Entity
@Table(name="medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="medicine_id")
	private long medicineId;
	
	@Column(name="medicine_name")
	private String medicineName;

	public long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(long medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Medicine(String medicineName) {
		super();
		this.medicineName = medicineName;
	}

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
