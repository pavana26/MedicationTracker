package com.medication.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medication.tracker.model.User;

/*
 * Author :Pavana
 * Version :1
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.userName = ?1 and u.password = ?2" )
	public User findUser(String userName, String password);
	
	@Query("SELECT u FROM User u WHERE u.userName = ?1" )
	public User findUserByUserName(String userName);

}
