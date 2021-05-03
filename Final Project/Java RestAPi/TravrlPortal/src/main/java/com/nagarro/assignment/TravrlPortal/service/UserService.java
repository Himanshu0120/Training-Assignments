package com.nagarro.assignment.TravrlPortal.service;

import java.util.List;

import com.nagarro.assignment.TravrlPortal.model.User;

public interface UserService {
	
	
	List<User> getUsers();
	String validateUser(String username,String password );
	User register(User u);
	User getUser(String username);

	String resetPassowrd(String email,String password);

}
