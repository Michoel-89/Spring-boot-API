package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.EmployeeService;
import com.example.demo.model.Employee;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/")
public class EmployeeAPIRoutes {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeAPIRoutes(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }


    @PostMapping("/")
    public String postEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Posted Employee";
    }

    @PatchMapping("/{id}")
    public String patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> fieldsToBeUpdated) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            // Process and apply the updates from fieldsToBeUpdated to the existingEmployee
            if (fieldsToBeUpdated.containsKey("name")) {
                existingEmployee.setName((String) fieldsToBeUpdated.get("name"));
            }
            if (fieldsToBeUpdated.containsKey("age")) {
                existingEmployee.setAge((int) fieldsToBeUpdated.get("age"));
            }
            if (fieldsToBeUpdated.containsKey("jobTitle")) {
                existingEmployee.setJobTitle((String) fieldsToBeUpdated.get("jobTitle"));
            }
            return "Patched Employee " + id;
        }
        return "Employee not found";
    }
    

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            employeeService.deleteEmployee(id);
            return "Deleted Employee " + id;
        }
        return "Employee not found " + id;
    }
}
