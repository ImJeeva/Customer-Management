package com.spring.DAOImplement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.DAO.CustomerDAO;
import com.spring.entity.Customer;

@Component
public class CustomerDAOImplement implements CustomerDAO{
	
	SessionFactory sf;

	@Autowired
	public CustomerDAOImplement(@Qualifier("sf") SessionFactory sf) { // calling this  sf method from my APPconfig class. 
		super();
		this.sf = sf;
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.persist(customer);
		t.commit();
		session.close();
		System.out.print("data stored.");
		
			

		
	}

	@Override
	public List<Customer> getALLCustomer() {
	    Session session = sf.openSession();
	    Transaction t = session.beginTransaction();
	    Query<Customer> q = session.createQuery("from Customer", Customer.class); // Use the entity class 'Customer'
	    List<Customer> list = q.getResultList();
	    t.commit();
	    session.close();
	    return list;
	}

	@Override
	public void updateCustomer(int id, String name, String email, String department, int salary) {
	    Session session = sf.openSession();  // Open a session
	    Transaction t = session.beginTransaction();  // Begin a transaction
	    
	    // Fetch the customer by ID
	    Customer c = session.get(Customer.class, id);
	    
	    if (c != null) {
	        // Set new values for the fields
	        c.setName(name);
	        c.setEmail(email);
	        c.setDepartment(department);
	        c.setSalary(salary);
	        
	        // Update the customer in the database
	        session.update(c);
	        
	        t.commit();  // Commit the transaction to save the changes
	        System.out.println("Customer with ID " + id + " updated successfully.");
	    } else {
	        System.out.println("Customer with ID " + id + " not found.");
	    }
	    
	    session.close();  // Close the session
	}


	@Override
	public void deleteCustomer(int id) {
	    Session session = sf.openSession();
	    Transaction t = session.beginTransaction();
		Customer c = session.get(Customer.class, id);
		session.delete(c);
	    t.commit();
	    session.close();
		
	}

	@Override
	public Customer getCustomerById(int id) {
	    Session session = sf.openSession();
	    Customer customer = null;
	    
	    try {
	        // Fetch the customer by ID
	        customer = session.get(Customer.class, id);
	        
	        if (customer != null) {
	            System.out.println("Customer found: " + customer);
	        } else {
	            System.out.println("No customer found with ID: " + id);
	        }
	    } finally {
	        session.close();  // Ensure session is closed after the operation
	    }
	    
	    return customer;
	}


}
