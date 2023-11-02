package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // Employee not found
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }
    
    @PostConstruct
    public void initializeEmployees() {
        Employee one = new Employee("John", 20, "Software Engineer");
        Employee two = new Employee("Travis", 29, "Software Engineer");

        employees.add(one);
        employees.add(two);

    }
}
