package com.training.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.training.models.Image;
import com.training.models.Users;

/**
 * Servlet implementation class Upload
 */
@MultipartConfig
@WebServlet("/upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part=request.getPart("img");
		HttpSession s=request.getSession();
		if(part.getSize()>1024*1024) {
			s.setAttribute("size","e");
			RequestDispatcher rd=request.getRequestDispatcher("/upload.jsp");
			rd.forward(request, response);
		}
		s.setAttribute("size","ne");
		String name=part.getSubmittedFileName();
		String path="D:"+File.separator+name;

		File fileSaveDir=new File(path);
		part.write(path+File.separator);
		
		
		Image img=new Image(name,part.getSize(),path,String.valueOf(s.getAttribute("username")));
		save(img);
		RequestDispatcher rd=request.getRequestDispatcher("/upload.jsp");
		rd.forward(request, response);
	}
	
	public static int save(Image img) {
		Configuration con=new Configuration().configure().addAnnotatedClass(Image.class).addAnnotatedClass(Users.class);
    	@SuppressWarnings("deprecation")
		SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	session.save(img);
    	
    	
    	tx.commit();
    	session.close();
    	sf.close();
    	return 0;
    	
	}
	
//	public boolean uploadFile(InputStream is,String path) throws IOException {
//		boolean test=false;
//		try {
//			byte[] byt=new byte[is.available()];
//			is.read();
//			FileOutputStream fops=new FileOutputStream(path);
//			fops.write(byt);
//			fops.flush();
//			fops.close();
//			test=true;
//		}
//		finally {
//			return test;
//		}
//	}

}
