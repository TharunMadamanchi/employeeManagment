package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;



    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }



    // Create employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.createEmployee(employee);
    }



    // Get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable long id){

        Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }



    // Update employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable long id,
            @RequestBody Employee employeeDetails){


        Employee updatedEmployee =
                employeeService.updateEmployee(id, employeeDetails);


        return ResponseEntity.ok(updatedEmployee);
    }



    // Delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(
            @PathVariable long id){


        employeeService.deleteEmployee(id);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}