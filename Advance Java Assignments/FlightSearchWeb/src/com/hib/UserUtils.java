package com.hib;
import org.hibernate.Query;


import com.models.Flight;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.models.User;

public class UserUtils {
	public static void addUser(User u) {
		Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(u);
		tx.commit();
    	session.close();
    	sf.close();
	}
	
	public static boolean checkUsername(String name) {
		Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		String q="from User where username=:name";
		Query query=session.createQuery(q);
		query.setParameter("name",name);
		if(query.list().size()==0) {
		tx.commit();
    	session.close();
    	sf.close();
    	return false;
		}
		else {
			tx.commit();
	    	session.close();
	    	sf.close();
	    	return true;
		}
	}
	
	public static boolean checkPassword(String name,String password) {
		Configuration con=new Configuration().configure().addAnnotatedClass(User.class);

		SessionFactory sf=con.buildSessionFactory();
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		String q="select password from User where username=:name";
		Query query=session.createQuery(q);
		query.setParameter("name",name);
		String pass=(String) query.uniqueResult();
		if(pass.equals(password)) {
			tx.commit();
	    	session.close();
	    	sf.close();
		return true;
		}
		else {
			tx.commit();
	    	session.close();
	    	sf.close();
			return false;
		}
	}
}
