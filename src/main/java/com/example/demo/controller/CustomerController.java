package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	@PostMapping("/add")
	public CustomerDto create(@RequestBody CustomerDto customerDto) {
		return customerService.createdcust(customerDto);
	}
	@PutMapping("/{id}")
	public CustomerDto update(@PathVariable Long id,@RequestBody CustomerDto customerDto) {
		return customerService.updateCust(customerDto,id);
	}
	@GetMapping("/{id}")
	public CustomerDto get(@PathVariable Long id) {
		return customerService.getCust(id);
	}
}
