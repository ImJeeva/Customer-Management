package com.spring.DAO;

import com.spring.entity.User;

public interface UserDAO {
	
	public void addUser(User user);
	public User getUser(String email);

}
