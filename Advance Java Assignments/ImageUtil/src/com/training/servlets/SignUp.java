package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.training.models.Users;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/RegisterUser")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserName=request.getParameter("username");
		String Password = request.getParameter("password");
		Users user=new Users(UserName,Password);
		
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Users.class);
    	@SuppressWarnings("deprecation")
		SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	Query query=session.createQuery("from Users where username=:username");
    	query.setParameter("username",UserName);
    	Users u=(Users)query.uniqueResult();
    	if(u!=null) {
    		
        	request.setAttribute("message","User already exists");
        	RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
        	rd.forward(request, response);
    	}
    	else {
    		HttpSession s=request.getSession();
    		s.setAttribute("username", UserName);
			session.save(user);
    	
    	
    	tx.commit();
    	session.close();
    	sf.close();
    	RequestDispatcher rd=request.getRequestDispatcher("/upload.jsp");
		rd.forward(request, response);
		
		
		
    	}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
