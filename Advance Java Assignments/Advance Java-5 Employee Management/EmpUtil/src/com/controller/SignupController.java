package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.UserUtils;
import com.helper.Helper;
import com.models.User;

@Controller
public class SignupController  {
	@RequestMapping("signup")
	public String SignUp(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		if(UserUtils.checkUsername(username)) {
			session.setAttribute("alert", "Username already exists");
			return "signup.jsp";
		}
		 User u=new User(username, password,name, email );
		 UserUtils.addUser(u);
			
		 List<JSONObject> res=new ArrayList<>();
			res=Helper.getAllEmp();
			session.setAttribute("EmpList", res);
			session.setAttribute("username",username);
			return "Welcome.jsp";
	}

}