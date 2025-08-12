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
		return employeeService.getAllEmployees();
	}
	
	@PatchMapping("/{id}")
	public EmployeeDto patialUpdate(@PathVariable Long id, @RequestBody EmployeeDto emp) {
		return employeeService.updatePartial(id, emp);
	}
	
	@DeleteMapping("/{id}")
	public EmployeeDto delete(@PathVariable Long id) {
		return employeeService.deleteEmp(id);
	}
	

}
