package com.medication.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medication.tracker.exception.CustomException;
import com.medication.tracker.model.User;
import com.medication.tracker.repository.UserRepository;
import com.medication.tracker.request.UserRequest;
import com.medication.tracker.response.Status;

/*
 * Author :Pavana
 * Version :1
 */

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {	
	
	@Autowired
	UserRepository userRepository;
	
	/* Authenticate user*/
	@PostMapping("/user")
	public ResponseEntity<Status> authenticateUser(@RequestBody UserRequest user){
		System.out.println("inside authenticateUser" );
		User userObj = userRepository.findUser(user.getUserName(),user.getPassword());
		if(null == userObj) {
			throw new CustomException("Invalid User");
		}	
		return ResponseEntity.ok(new Status("success",userObj.getUserId().toString()));
	}
	
	/*Register User */
	@PostMapping("/user/registration")
	public ResponseEntity<Status> registerUser(@RequestBody UserRequest user){
		System.out.println("inside reguser" );
		User userObj = userRepository.findUserByUserName(user.getUserName());
		if(null != userObj) {
			throw new CustomException(" UserName already exists");
		}	
		userObj =new User(user.getUserName(),user.getPassword(),user.getEmail(),user.getAddress(),user.getPhone());
		userRepository.save(userObj);
		return ResponseEntity.ok(new Status("success",userObj.getUserId().toString()));
	}
	

}
