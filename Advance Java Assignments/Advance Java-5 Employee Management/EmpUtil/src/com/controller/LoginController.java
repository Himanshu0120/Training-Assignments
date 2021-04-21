package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserUtils;
import com.helper.Helper;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response)
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		
		if(!UserUtils.checkUsername(username)) {
			session.setAttribute("alert", "Username does not exists");
			
			return "index.jsp";
		}
		if(UserUtils.checkPassword(username, password)) {
			List<JSONObject> res=new ArrayList<>();
			res=Helper.getAllEmp();
			session.setAttribute("EmpList", res);
			session.setAttribute("username",username);
			return "Welcome.jsp";
			
			
//			
			}
		else 
			session.setAttribute("alert","Wrong Password");
		return "index.jsp";
	}
}
