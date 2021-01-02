package com.medication.tracker.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medication.tracker.exception.CustomException;
import com.medication.tracker.model.Medicine;
import com.medication.tracker.model.UserMedicine;
import com.medication.tracker.repository.MedicineRepository;
import com.medication.tracker.repository.UserMedicineRepository;
import com.medication.tracker.request.MedicineRequest;
import com.medication.tracker.request.SearchRequest;
import com.medication.tracker.request.UserMedicineRequest;
import com.medication.tracker.response.MedicineDetail;
import com.medication.tracker.response.UserMedicineItem;
import com.medication.tracker.response.UserMedicineResponse;
import com.medication.tracker.response.UserMedicineSearchResponse;
import com.medication.tracker.util.DateUtil;



/*
 * Author :Pavana
 * Version :1
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserMedicineController {

	@Autowired
	UserMedicineRepository userMedicineRepository;

	@Autowired
	MedicineRepository medicineRepository;

	/* Get all medicines for dropdown */
	@GetMapping("/medicines")
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	/* Create new medicine */
	@PostMapping("/medicines/addmedicine")
	public Medicine addMedicine(@RequestBody MedicineRequest medicine) {
		Medicine medicineObj = medicineRepository.getByName(medicine.getMedicineName());
		if(null != medicineObj) {
			throw new CustomException("Name already exists");
		}
		medicineObj = new Medicine();
		medicineObj.setMedicineName(medicine.getMedicineName());
		return medicineRepository.save(medicineObj);
	}

	/* Get all user medicines */
	@GetMapping("/medicines/UserMedicine")
	public List<UserMedicine> getAllUserMedicines() {
		return userMedicineRepository.findAll();
	}

	/* Get user medicines by range of dates */
	@PostMapping("/medicines/UserMedicine/search")
	public UserMedicineSearchResponse getUserMedicinesByDate(@RequestHeader("userId") String userId,
			@RequestBody SearchRequest searchRequest) {
		List<UserMedicine> dbList = userMedicineRepository.getMedicineByDts(Integer.parseInt(userId));
		UserMedicineSearchResponse response = new UserMedicineSearchResponse();
		List<UserMedicineItem> umList = new ArrayList<>();
		Date start = searchRequest.getFromDate();
		Date end = searchRequest.getToDate();
		UserMedicineItem medItem = null;
		while (start.before(end) || start.equals(end)) {
			medItem = new UserMedicineItem();
			medItem.setDateOfWeek(DateUtil.getDateToString(start));
			List<MedicineDetail> medDetail = new ArrayList<>();
			for (UserMedicine med : dbList) {
				MedicineDetail mdetail = null;
				if (med.getStartDate().before(start) && med.getEndDate().after(start)) {
					mdetail = new MedicineDetail();
					mdetail.setUsermedicineId(med.getUserMedicineId());
					mdetail.setAmount(med.getAmount());
					mdetail.setDose(med.getDose());
					mdetail.setFrequency(med.getFrequency());
					mdetail.setInstructions(med.getInstructions());
					mdetail.setMedicineName(med.getMedicineName());
				}
				if (null != mdetail) {
					medDetail.add(mdetail);
				}

			}
			medItem.setMedDetail(medDetail);
			medItem.setDayOfWeek(DateUtil.getDay(start));
			umList.add(medItem);
			// add one day to date
			start = DateUtil.dayPlusOne(start);

		}
		response.setUserMedicineList(umList);
		return response;
	}



	/* Add user medicines */
	@PostMapping("/medicines/UserMedicine")
	public UserMedicine addUserMedicine(@RequestHeader("userId") String userId,@RequestBody UserMedicineRequest userMedicineReq) {

		UserMedicine userMedicine = new UserMedicine();
		userMedicine.setMedicineName(userMedicineReq.getMedicineName());
		userMedicine.setInstructions(userMedicineReq.getInstructions());
		userMedicine.setStartDate(userMedicineReq.getFromDate());
		userMedicine.setEndDate(userMedicineReq.getToDate());
		userMedicine.setUserId(Integer.parseInt(userId));
		userMedicine.setAmount(userMedicineReq.getAmount());
		userMedicine.setDose(userMedicineReq.getDose());
		userMedicine.setFrequency(userMedicineReq.getFrequency());
		return userMedicineRepository.save(userMedicine);

	}

	/* Get UserMedicine By Id */
	@GetMapping("/medicines/UserMedicine/{userMedicineId}")
	public ResponseEntity<UserMedicineResponse> getUserMedicineById(@PathVariable Integer userMedicineId) {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);

		UserMedicine userMedicine = userMedicineRepository.findById(Integer.valueOf(userMedicineId))
				.orElseThrow(() -> new CustomException("Medicine Details Not Found for this Id"));

		UserMedicineResponse response = new UserMedicineResponse();
		BeanUtils.copyProperties(userMedicine, response);
		if (null != response.getStartDate()) {
			DateFormatUtils.format(response.getStartDate(), "yyyy-MM-dd'T'HH:mm'Z'");
		}
		if (null != response.getEndDate()) {
			DateFormatUtils.formatUTC(response.getEndDate(), "yyyy-MM-dd'T'HH:mm'Z'");
		}

		return ResponseEntity.ok(response);

	}

	/* Update UserMedicine */
	@PutMapping("/medicines/UserMedicine/{userMedicineId}")
	public ResponseEntity<UserMedicine> updateUserMedicine(@RequestHeader("userId") String userId,@PathVariable Integer userMedicineId,
			@RequestBody UserMedicineRequest userMedicineReq) {

		UserMedicine userMedicine = userMedicineRepository.findById(userMedicineId)
				.orElseThrow(() -> new CustomException("Medicine Details Not Found for this Id"));
		userMedicine.setMedicineName(userMedicineReq.getMedicineName());
		userMedicine.setInstructions(userMedicineReq.getInstructions());
		userMedicine.setStartDate(userMedicineReq.getFromDate());
		userMedicine.setEndDate(userMedicineReq.getToDate());
		userMedicine.setAmount(userMedicineReq.getAmount());
		userMedicine.setDose(userMedicineReq.getDose());
		userMedicine.setFrequency(userMedicineReq.getFrequency());
		UserMedicine updatedUserMedicine = userMedicineRepository.save(userMedicine);
		return ResponseEntity.ok(updatedUserMedicine);
	}

	/* Delete UserMedicine */
	@DeleteMapping("/medicines/UserMedicine/{userMedicineId}")
	public ResponseEntity<Map<String, Boolean>> deleteUserMedicine(@PathVariable Integer userMedicineId) {
		UserMedicine userMedicine = userMedicineRepository.findById(userMedicineId)
				.orElseThrow(() -> new CustomException("Medicine Details Not Found for this Id"));
		userMedicineRepository.delete(userMedicine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
