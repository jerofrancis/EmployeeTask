package com.example.thymeleaf.controller;

import com.example.thymeleaf.dto.EmployeeDto;
import com.example.thymeleaf.entity.Employee;
import com.example.thymeleaf.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/displayAll")
    public String viewHomePage(Model model){
        model.addAttribute("allemplist", employeeService.getAllEmployees());
        return "viewAll";
    }

    @GetMapping("/")
    public String addNewEmployee(Model model){
        //map to dto & handle entity
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model){
        //map to dto & handle entity
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "searchEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")EmployeeDto employeeDto){
        employeeService.save(employeeDto);
        return "redirect:/";
    }

    @GetMapping("/singleEmp")
    public String getEmployee(@RequestParam String empId, Model model) {
        Employee employee = employeeService.getEmployeeById(empId);
        model.addAttribute("employee", employee);
        return "searchEmployee";
    }

}
