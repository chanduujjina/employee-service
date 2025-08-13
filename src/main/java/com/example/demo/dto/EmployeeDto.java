package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {
	
	private Long id;
	@Valid
	private String name;
	private String role;
	@NotNull
	private String salary;

}
