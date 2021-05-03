package com.nagarro.assignment.TravrlPortal.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment.TravrlPortal.model.User;
import com.nagarro.assignment.TravrlPortal.service.MailService;
import com.nagarro.assignment.TravrlPortal.service.UserService;
import com.nagarro.assignment.TravrlPortal.utils.PasswordGenerator;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	MailService mailservice;
	
	PasswordGenerator passwordService=new PasswordGenerator(); 
	
	@GetMapping("")
	public List<User> getUsers(){
		
		return userService.getUsers();
	}
	
	@PostMapping("")
	public User register(@RequestBody User u) {
		String password=passwordService.generatePassword(8);
		String to=u.getEmail();
		mailservice.passwordEmail(password, to);
		u.setPassword(password);
		userService.register(u);
		return u; 
	}
	
	@PostMapping("/validate")
	public String validate(@RequestBody Map<String,Object> args) {
		String username=((String) args.get("username")).toLowerCase();
		String password=(String) args.get("password");
		
	return userService.validateUser(username, password);
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getUser(username.toLowerCase());
	}
	
	@PostMapping("/reset")
	public void resetPassword(@RequestBody Map<String,Object> args) {
		String email=(String) args.get("email");
		String password=passwordService.generatePassword(8);
		mailservice.resetPassword(password, email);
		userService.resetPassowrd(email, password);
		return;
		
	}
}
