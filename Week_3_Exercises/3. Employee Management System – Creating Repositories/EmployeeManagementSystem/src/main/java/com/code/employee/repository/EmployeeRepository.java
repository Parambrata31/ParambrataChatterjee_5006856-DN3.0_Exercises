package com.code.employee.repository;

import com.code.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Derived query methods
    
    // Find employees by their department name
    List<Employee> findByDepartmentName(String departmentName);
    
    // Find an employee by their email
    Employee findByEmail(String email);
    
    // Find all employees with a name containing a specific substring
    List<Employee> findByNameContaining(String name);
}