package com.example.demo.dto;
import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
=======
import lombok.Data;

@Data
>>>>>>> ee03b608d7bfb872dd7f2f65e0bfaa223987d138
public class EmployeeDto {
	
	private Long id;

	private String emp_name;
	@Valid
	private String role;
	@NotNull
	private String salary;
	
	
}
