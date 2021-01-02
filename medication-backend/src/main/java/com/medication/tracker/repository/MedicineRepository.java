package com.medication.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medication.tracker.model.Medicine;

/*
 * Author :Pavana
 * Version :1
 */
public interface MedicineRepository extends JpaRepository<Medicine,Integer>{

	@Query("SELECT m FROM Medicine m WHERE m.medicineName = ?1 " )
	public Medicine getByName(String name);
}
