package com.spring.DAOImplement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.DAO.UserDAO;
import com.spring.entity.User;


@Component
public class UserDAOImplement implements UserDAO {

	SessionFactory sf;

	@Autowired
	public UserDAOImplement(@Qualifier("sf") SessionFactory sf) { // calling this  sf method from my APPconfig class. 
		super();
		this.sf = sf;
	}
	
	
	@Override
	public void addUser(User user) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.persist(user);
		t.commit();
		session.close();
		System.out.print("user data stored.");
		
	}
	public User getUser(String email) {
		Session session = sf.openSession();
		User user = null;
		 try {
		        // Fetch the customer by ID
				String hql = "FROM User WHERE email = :email";
				Query query = session.createQuery(hql);
				query.setParameter("email", email);
				user = (User) query.uniqueResult();
		        
		        if (user != null) {
		            System.out.println("Customer found: " + user);
		        } else {
		            System.out.println("No customer found with ID: " + email);
		        }
		    } finally {
		        session.close();  // Ensure session is closed after the operation
		    }
		 System.out.println(user);
		
		return user;
	}
	
	// Assuming you have a User entity with an "email" field


	
	
	
	
	
	

}
