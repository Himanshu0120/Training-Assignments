package com.nagarro.assignment.TravrlPortal.dao;

import java.util.List;

import com.nagarro.assignment.TravrlPortal.model.User;

public interface UserDao {
	List<User> get();
	
	String validateUser(String username,String password);
	
	String updatePassword();

	User registerUser(User u);
	
	User getUser(String username);
	
	String resetPassword(String email,String password);
	
	
	
	

}
