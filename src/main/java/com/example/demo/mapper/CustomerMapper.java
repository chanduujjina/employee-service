package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	CustomerMapper INSTANCE=Mappers.getMapper(CustomerMapper.class);
	CustomerDto tocDto(Customer customer);
	Customer tocEntity(CustomerDto customer);


}
