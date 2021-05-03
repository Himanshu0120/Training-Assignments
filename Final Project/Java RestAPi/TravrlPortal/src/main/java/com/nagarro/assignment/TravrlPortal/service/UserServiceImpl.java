package com.nagarro.assignment.TravrlPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignment.TravrlPortal.dao.UserDao;
import com.nagarro.assignment.TravrlPortal.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;
	
	public List<User> getUsers(){
		return dao.get();
	}

	@Override
	public String validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return dao.validateUser(username, password);
		
	}

	@Override
	public User register(User u) {
		// TODO Auto-generated method stub
		return dao.registerUser(u);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return dao.getUser(username);
	}

	@Override
	public String resetPassowrd(String email, String password) {
		// TODO Auto-generated method stub
		return dao.resetPassword(email, password);
	}

	

}
