package com.code.employee.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.employee.entity.Employee;
import com.code.employee.repository.EmployeeRepository;

@RestController
	@RequestMapping("/api/employees")
	public class EmployeeController {

	    @Autowired
	    private EmployeeRepository employeeRepository;

	    // Create a new Employee
	    @PostMapping("/add")
	    public Employee createEmployee(@RequestBody Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    // Get all Employees
	    @GetMapping("/")
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }
	    // Get a single Employee by ID
	    @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable int id) {
	        Employee employee = employeeRepository.findById(id).get();
	        return employee;
	    }

	    // Update an Employee
	    @PutMapping(value="/{id}")
	    //@path variable used to get the variable passed from url
	    //http://localhost:8080/api/employee/1
	    //@PathVariable int id returns 1
	    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeDet) {
	    	//returns the object of Optional class
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        //checking any object is present or not
	        if (optionalEmployee.isPresent()) 
	        {
	        	//setting the new value
	            Employee employee = optionalEmployee.get();
	            employee.setName(employeeDet.getName());
	            employee.setEmail(employeeDet.getEmail());
	            employee.setDepartment(employeeDet.getDepartment());
	            //Saving the object
	            Employee updatedEmployee = employeeRepository.save(employee);
	            //returning the object
	            return updatedEmployee;
	        } 
	        else 
	        {
	        	//returning null if no object is found
	            return null;
	        }
	       
	    }

	    // Delete an Employee
	    
	    @DeleteMapping(value="/{id}")
	    public String  deleteDepartment(@PathVariable int id) {
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            employeeRepository.deleteById(id);
	            return ("Department with id" +id+"deleted successfully");
	        }
	        return "Employee with id" +id+" not found";
	    }
	    
	    //named query
	    @GetMapping(value="email/{email}")
	    public Employee findByEmail(@PathVariable String email)
	    {
	    	return employeeRepository.findByEmailNamed(email);
	    }
	    @GetMapping(value="department/{id}")
	    public List<Employee> findByDepartmentId(@PathVariable int id)
	    {
	    	return employeeRepository.findByDepartmentIdNamed(id);
	    }
}