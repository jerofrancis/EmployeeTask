package com.example.thymeleaf.repository;

import com.example.thymeleaf.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    //custom methods here
    Employee findByEmpId(String empId);
}
