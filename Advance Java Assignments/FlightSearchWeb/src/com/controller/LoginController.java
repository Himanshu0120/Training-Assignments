package com.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.AddCsv;
import com.hib.UserUtils;
import com.opencsv.exceptions.CsvValidationException;

@Controller
public class LoginController  {
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws CsvValidationException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		if(!UserUtils.checkUsername(username)) {
			session.setAttribute("alert", "Username does not exists");
			return "index.jsp";
		}
		if(UserUtils.checkPassword(username, password)) {

			String path=request.getSession().getServletContext().getRealPath(File.separator);
			AddCsv.Add(path);
//			
			return "Welcome.jsp";}
		else 
			session.setAttribute("alert", "Wrong password");
		return "index.jsp";
	}
}
