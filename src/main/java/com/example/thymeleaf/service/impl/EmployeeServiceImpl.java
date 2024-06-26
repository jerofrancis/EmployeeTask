package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.dto.EmployeeDto;
import com.example.thymeleaf.entity.Employee;
import com.example.thymeleaf.repository.EmployeeRepository;
import com.example.thymeleaf.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelmapper;

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public void save(EmployeeDto employeeDto) {
        employeeRepository.save(modelmapper.map(employeeDto, Employee.class));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String empId) {
        return employeeRepository.findByEmpId(empId);
    }
}
