package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmplyeeMapper {

	EmplyeeMapper INSTANCE = Mappers.getMapper(EmplyeeMapper.class);
	
	EmployeeDto toDto(Employee employee);
	Employee toEntity(EmployeeDto employeeDto);

}
