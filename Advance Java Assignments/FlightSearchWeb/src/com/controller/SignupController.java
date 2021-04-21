package com.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.AddCsv;
import com.hib.UserUtils;
import com.models.User;
import com.opencsv.exceptions.CsvValidationException;

@Controller
public class SignupController  {
	@RequestMapping("signup")
	public String SignUp(HttpServletRequest request, HttpServletResponse response) throws CsvValidationException, IOException {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		if(UserUtils.checkUsername(username)) {
			session.setAttribute("alert", "Username already exists");
			return "signup.jsp";
		}
		 User u=new User(firstname, lastname, username, password);
		 UserUtils.addUser(u);
		 String path=request.getSession().getServletContext().getRealPath(File.separator);
			AddCsv.Add(path);
		return "Welcome.jsp";
	}

}