package com.code.employee.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.employee.entity.Employee;
import com.code.employee.projection.EmployeeProjection;
import com.code.employee.projection.EmployeeValueProjection;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	@Query(name="Employee.findByEmailNamed")
	Employee findByEmailNamed(@Param("email") String email);
	
	@Query(name="Employee.findByDepartmentIdNamed")
	List<Employee> findByDepartmentIdNamed(@Param("departmentId") int departmentId);

	//Derived Query Methods
	//List<Employee> findByName(String name);
	//List<Employee> findByDepartmentId(int departmentId);
	//List<Employee> findByEmail(String email);
	
	//find all the employees with pagination and sorting 
	Page<Employee> findAll(Pageable pageable);
	
	//find all the employees with pagination and sorting 
	Page<Employee> findByDepartmentId(int departmentId, org.springframework.data.domain.Pageable pageable);
	
	//adding the query for employee projection
	@Query("SELECT e.name as name,e.email as email FROM Employee e")
	List<EmployeeProjection> findByEmployee();
	//adding the query for employee projection by value
	@Query("SELECT e.name as name,e.email as email FROM Employee e WHERE e.department.name = :departmentName")
	List<EmployeeValueProjection> findByDepartmentName1(@Param("departmentName") String departmentName);
	
	
	
}