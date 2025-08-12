package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFound(EmployeeNotFoundException ex){ //Map<String, String>
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	} //Employee not found
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex){
		return new ResponseEntity<>("Internal server error" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
