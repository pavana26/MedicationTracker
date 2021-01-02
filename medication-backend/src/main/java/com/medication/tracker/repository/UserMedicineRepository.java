package com.medication.tracker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.medication.tracker.model.UserMedicine;

/*
 * Author :Pavana
 * Version :1
 */
public interface UserMedicineRepository  extends JpaRepository<UserMedicine,Integer>{
	
	@Query("SELECT um FROM UserMedicine um WHERE um.userId = ?1 " )
	List<UserMedicine> getMedicineByDts(Integer userId);

}
