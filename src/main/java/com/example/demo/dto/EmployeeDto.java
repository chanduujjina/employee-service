package com.example.demo.dto;
import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class EmployeeDto {
	
	private Long id;

	private String emp_name;
	@Valid
	private String role;
	@NotNull
	private String salary;
	
	
}
