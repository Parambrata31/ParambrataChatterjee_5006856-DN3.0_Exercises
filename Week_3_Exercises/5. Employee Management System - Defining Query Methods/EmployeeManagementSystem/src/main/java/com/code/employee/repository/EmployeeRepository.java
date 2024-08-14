package com.code.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	//Using the named query defined in Employee entity
	@Query(name = "Employee.findByEmail")
	Employee findByEmailNamed(@Param("email") String email);
	
	//Using the named query defined in Employee entity
	@Query(name = "Employee.findByDepartmentId")
	List<Employee> findByDepartmentIdNamed(@Param("departmentId") int departmentId);
	//under one department there can be many employees

}