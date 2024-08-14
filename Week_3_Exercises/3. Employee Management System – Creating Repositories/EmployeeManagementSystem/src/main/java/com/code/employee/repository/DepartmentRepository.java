package com.code.employee.repository;

import com.code.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Derived query methods
    
    // Find a department by its name
    Department findByName(String name);
    
    // Check if a department exists by its name
    boolean existsByName(String name);
}
