package com.code.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.employee.entity.Department;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	//Derived query methods
	//custom jpql query to find a dept by name
	@Query("SELECT d FROM Department d WHERE d.name=:name")
	Department findByNameUsingJPQL(@Param("name") String name);
	
	///by default nativeQuery=false so when we want  to use sql  query nativequery is set to be  true
	@Query(value=" SELECT * FROM departments d WHERE d.name LIKE %:pattern%", nativeQuery=true)
	List<Department> findByNamePattern(@Param("pattern") String pattern);
	Department findByName(String name);
	
}