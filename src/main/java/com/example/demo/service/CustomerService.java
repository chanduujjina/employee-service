package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	
	public CustomerService(CustomerRepository customerRepository,CustomerMapper customerMapper) {
		this.customerRepository=customerRepository;
		this.customerMapper=customerMapper;
		
	}
	public CustomerDto createdcust(CustomerDto cust) {
		Customer customer= customerMapper.tocEntity(cust);
		customerRepository.save(customer);
		return customerMapper.tocDto(customer);
	}
	public CustomerDto updateCust(CustomerDto customerDto, Long id) {
		Customer customer= customerRepository.findById(id).orElseThrow();
		customer.setName(customerDto.getName());
		customer.setQauntity(customerDto.getQauntity());
		customerRepository.save(customer);
		return customerMapper.tocDto(customer);
	}
	public CustomerDto getCust(Long id) {
		Optional<Customer> cust = customerRepository.findById(id);
		if(cust.isPresent()) {
			Customer customer = cust.get();
			return customerMapper.tocDto(customer);
		}
		return null;
	}
	
}
