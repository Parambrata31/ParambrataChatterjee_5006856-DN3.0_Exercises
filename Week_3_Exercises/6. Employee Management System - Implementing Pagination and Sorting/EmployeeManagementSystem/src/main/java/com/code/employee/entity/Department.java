package com.code.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="departments")
@Getter
@Setter
public class Department {


	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
              //adding constraints unique=true  to disalllow duplicate departemntnames
	    @Column(nullable = false,unique=true)
	    private String name;

	   // @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	   // private List<Employee> employees;
	    
	    
	    public Department() {
	    	this.id=0;
	    	this.name=null;
	    	//this.employees=null;
	    	
	    }
	  //generate  the getter and setter
	  	public int getid() {
	  		return id;
	  	}
	  	public void setid(int id) {
	  		this.id = id;
	  	}
	  	public String getName() {
	  		return name;
	  	}
	  	public void setName(String name) {
	  		this.name = name;
	  	}
	  	//public List<Employee> getEmployees() {
	  	 //   return employees;
	  	//}

	  //	public void setEmployees(List<Employee> employees) {
	  	 //   this.employees = employees;
	  //	}
}