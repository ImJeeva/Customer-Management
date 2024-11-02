package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "springcurd")
public class Customer {
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "department")
	private String department;
	@Column(name = "salary")
	private int salary;
	
	public Customer (){
		
	}
	
	public Customer (String name, String email, String department, int salary) {
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
		
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public String toString() {
		return id+", "+name+", "+email+", "+department+", "+salary;
	}
	
}
