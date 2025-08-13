package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add")
	public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
		return employeeService.createEmployee(employeeDto);
	}
	
	@PutMapping("/{id}")
	public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeDto emp) {
		return employeeService.updateEmployee(id, emp);
	}
	@GetMapping("/get/{id}")
	public EmployeeDto getdata(@PathVariable Long id) {
		return employeeService.getEmployee(id);
	}
	@DeleteMapping("/{id}")
	public EmployeeDto delete(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/allEmplyees")
	public List<EmployeeDto> getAllEmployeeDetails(){
		if(employeeService.getAllEmployees().isEmpty()) {
			throw new RuntimeException("No employees found");
		}
		return employeeService.getAllEmployees();
	}
	
	@PatchMapping("/{id}")
	public EmployeeDto patialUpdate(@PathVariable Long id, @RequestBody EmployeeDto emp) {
		if(emp.getName() == null && emp.getRole() == null && emp.getSalary() == null) {
			throw new RuntimeException("At least one field must be provided for partial update");
		}
		return employeeService.updatePartial(id, emp);
	}
	
	@DeleteMapping("/{id}")
<<<<<<< HEAD
	public EmployeeDto delete1(@PathVariable Long id) {
=======
	public EmployeeDto delete(@PathVariable Long id) {
		if(id == null) {
			throw new RuntimeException("Id cannot be null");
		}
>>>>>>> ee03b608d7bfb872dd7f2f65e0bfaa223987d138
		return employeeService.deleteEmp(id);
	}
	@GetMapping("/{id}")
	public EmployeeDto getEmployeeById(@PathVariable Long id) {
		if(id == null) {
			throw new RuntimeException("Id cannot be null");
		}
		return employeeService.getEmployeeById(id);
	}
	

}
