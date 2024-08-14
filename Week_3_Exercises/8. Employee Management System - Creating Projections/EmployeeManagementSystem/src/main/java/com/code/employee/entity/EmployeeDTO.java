package com.code.employee.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
//creating this class to pass the  value at the  time of new record
public class EmployeeDTO {
	private String name;
	private String email;
	private double salary;
	private int deptid;
 public EmployeeDTO()
 {
	 this.name="";
	 this.email="";
	 this.salary=0;
	 this.deptid=0;
 }
 public String getName() {
	    return name;
	}

	public String getEmail() {
	    return email;
	}

	public double getSalary() {
	    return salary;
	}

	public int getDeptid() {
	    return deptid;
	}

}
