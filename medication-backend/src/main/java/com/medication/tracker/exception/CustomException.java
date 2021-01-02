package com.medication.tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Author :Pavana
 * Version :1
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 753726714353068856L;
	
	public CustomException(String message) {
		super(message);
	}

}
