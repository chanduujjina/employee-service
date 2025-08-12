package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.mapper.EmplyeeMapper;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final EmplyeeMapper emplyeeMapper;
	
	public EmployeeService(EmployeeRepository employeeRepository, EmplyeeMapper emplyeeMapper) {
		this.employeeRepository = employeeRepository;
		this.emplyeeMapper = emplyeeMapper;
	}
	
	
	public EmployeeDto createEmployee(EmployeeDto emp) {
		Employee employee = emplyeeMapper.toEntity(emp);
		System.out.println(employee.toString());
		Employee result = employeeRepository.save(employee); // INSERT INRO EMPLOYEE (ID, NAME, ROLE, SALARY) VALUES (1, "Ramu", "Developer", 50000);
		return emplyeeMapper.toDto(result);

	}


	public EmployeeDto updateEmployee(Long id, EmployeeDto emp) {
		Employee employee =employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		employee.setName(emp.getEmp_name());
		employee.setRole(emp.getRole());
		employee.setSalary(emp.getSalary());
		employeeRepository.save(employee); //SELECT * FROM  EMPLOYEE WHERE ID = 1, IF YES ->  UPDATE EMPLOYEE SET NAME = "RAMU" WHERE ID = 1;
		return emplyeeMapper.toDto(employee);
	}

	public EmployeeDto getEmployee(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			Employee employee = optional.get();
			return emplyeeMapper.toDto(employee);
		}
		return null;
	}
	public EmployeeDto deleteEmployee(Long id) {
		Employee employe = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		employeeRepository.delete(employe);
		return null;
	}
	public List<EmployeeDto> getAllEmployees() {
		
		List<Employee> employee = employeeRepository.findAll();
		if(employee.isEmpty()) {
			throw new EmployeeNotFoundException("No Employees found");
		}
		return employee.stream().map(emplyeeMapper::toDto).collect(Collectors.toList());
	}


	public EmployeeDto updatePartial(Long id, EmployeeDto emp) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			Employee empObj = employee.get();
			if(emp.getName() != null) {
				empObj.setName(emp.getName());
			}if(emp.getRole() != null) {
				empObj.setRole(emp.getRole());
			}if(emp.getSalary() != null) {
				empObj.setSalary(emp.getSalary());
			}
			employeeRepository.save(empObj);
			return emplyeeMapper.toDto(empObj);
		}
		return null;
	}


	public EmployeeDto deleteEmp(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.delete(employee.get());

		}
		throw new EmployeeNotFoundException("Employee not foud");

	}

}
