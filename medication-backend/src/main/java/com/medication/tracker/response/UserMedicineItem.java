package com.medication.tracker.response;

/*
 * Author :Pavana
 * Version :1
 */
import java.util.List;

public class UserMedicineItem {
		
	private String dateOfWeek;
	
	private String dayOfWeek;
	
	private List<MedicineDetail> medDetail;
	
	public String getDateOfWeek() {
		return dateOfWeek;
	}

	public void setDateOfWeek(String dateOfWeek) {
		this.dateOfWeek = dateOfWeek;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<MedicineDetail> getMedDetail() {
		return medDetail;
	}

	public void setMedDetail(List<MedicineDetail> medDetail) {
		this.medDetail = medDetail;
	}
	
	public UserMedicineItem(String dateOfWeek, String dayOfWeek, List<MedicineDetail> medDetail) {
		super();
		this.dateOfWeek = dateOfWeek;
		this.dayOfWeek = dayOfWeek;
		this.medDetail = medDetail;
	}

	public UserMedicineItem() {
		
	}
	
}