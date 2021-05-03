package com.nagarro.assignment.TravrlPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void passwordEmail(String password,String to) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("2017003126.himanshu@gmail.com");
		msg.setTo(to);
		msg.setSubject("Travel Portal Password");
		msg.setText("Your password is : "+password +"and your username is : "+to);
		mailSender.send(msg);
		System.out.println("Mail sent");
	}
	
	public void resetPassword(String password,String to) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("2017003126.himanshu@gmail.com");
		msg.setTo(to);
		msg.setSubject("Travel Portal Password Reset");
		msg.setText("Your new password is "+password);
		mailSender.send(msg);
		System.out.println("Mail sent");
	}
	

}
