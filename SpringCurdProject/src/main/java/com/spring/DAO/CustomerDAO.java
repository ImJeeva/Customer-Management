package com.spring.DAO;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerDAO {
	public Customer getCustomerById(int id);
	public void addCustomer(Customer customer);
	
	public List<Customer> getALLCustomer();
	
	public void updateCustomer(int id, String name, String email, String department, int salary);
	
	public void deleteCustomer(int id);
	
	

}
