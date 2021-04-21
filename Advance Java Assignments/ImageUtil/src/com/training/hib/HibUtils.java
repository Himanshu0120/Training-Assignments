package com.training.hib;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.training.models.Image;
import com.training.models.Users;

public class HibUtils {
	
	public static ArrayList<Image> getImages(String username){
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Image.class).addAnnotatedClass(Users.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Query query = session.createQuery("from Image where username=:username");
		query.setParameter("username",username);
		ArrayList<Image> list=(ArrayList<Image>) query.list();
		if(list==null)
			return null;
		return list;
	}
}
