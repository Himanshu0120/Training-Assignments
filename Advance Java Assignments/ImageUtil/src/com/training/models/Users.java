package com.training.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	
	String username ;
	String pass ;
	public Users(String userName, String pass) {
		super();
		this.username = userName;
		this.pass = pass;
	}
	public Users() {}
	
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		pass = pass;
	}
	
}
