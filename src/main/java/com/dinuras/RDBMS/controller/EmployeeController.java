package com.dinuras.RDBMS.controller;

import com.dinuras.RDBMS.Service.EmployeeServiceImpl;
import com.dinuras.RDBMS.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {

    @RequestMapping("/employeeServices")
    public String bonjour(){

        return "<h1>YEET</h1>";

    }

    @RequestMapping(value = "/employees")
    public List<Employee> employees(){
        return Employee.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{id}")
    public Employee employee(){
        return null;
    }

    @Autowired
    EmployeeServiceImpl service;

    @GetMapping("/show")
    public List<Employee> viewEmployees() {
        return service.getEmployees();
    }

    @PostMapping(path = "/add")
    public void postEmployee(@RequestBody Employee emp) {
        service.add(emp);
    }


}