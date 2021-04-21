package com.hib;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.models.Flight;

public class FlightUtils {
	public static void addToDb(Flight f) {
		Configuration con=new Configuration().configure().addAnnotatedClass(Flight.class);
    	@SuppressWarnings("deprecation")
		SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	String q="from Flight where flight_no=:f and flight_class=:c";
    	 Query query = session.createQuery(q);
    	 query.setParameter("c",f.getFClass());
    	query.setParameter("f",f.getFlightNo());
    	if(query.list().size()==0)
    		session.save(f);
    	tx.commit();
    	session.close();
    	sf.close();
	}
 
	
	
	public static ArrayList<Flight> searchFlight(String dep,String arr){
		Configuration con=new Configuration().configure().addAnnotatedClass(Flight.class);
		SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	String q="from Flight where dep_loc=:dep and arr_loc=:arr";
    	Query query=session.createQuery(q);
    	query.setParameter("arr",arr);
    	query.setParameter("dep",dep);
    	
    	ArrayList<Flight> res=(ArrayList<Flight>) query.list();
		return res;
	}
}
