package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmplyeeMapper {

	EmplyeeMapper INSTANCE = Mappers.getMapper(EmplyeeMapper.class);

	@Mapping(source="name", target ="emp_name")
	EmployeeDto toDto(Employee employee);
	@Mapping(source="emp_name", target ="name")
	Employee toEntity(EmployeeDto employee);

}
