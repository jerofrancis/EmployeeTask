package com.example.thymeleaf.service;

import com.example.thymeleaf.dto.EmployeeDto;
import com.example.thymeleaf.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void save(EmployeeDto employeeDto);

    //EmployeeDto getById(Long id);

    Employee getEmployeeById(String empId);

    List<Employee> getAllEmployees();


    //update -> task
}
