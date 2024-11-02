package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	private int userId;
	@Column(name = "name")
	private String uName;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;


	
	
	public User() {
		
	}


	public User( String uName, String password, String email) {
		super();
//		this.userID = userID;
		this.uName = uName;
		this.password = password;
		this.email = email;

	}


	public int getUserID() {
		return userId;
	}


	public void setUserID(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return uName;
	}


	public void setUserName(String uName) {
		this.uName = uName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	public String toString() {
		return userId+" "+uName+" "+password+" "+email;
	}

}
