package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<String> handleResourceNotFound(EmployeeNotFoundException ex){ //Map<String, String>
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//	} //Employee not found
//	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String, String>> employeeNotFound(EmployeeNotFoundException ex){ //Map<String, String>
		Map<String, String> errorResponse =new HashMap<>();
		errorResponse.put("error", ex.getMessage());
		errorResponse.put("status", "404 Not Found");
		errorResponse.put("timestamp", String.valueOf(System.currentTimeMillis()));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex){
		return new ResponseEntity<>("Internal server error" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
