package defaultPackage;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class HibUtils {
	public static void addToDb(Flight f) {
		Configuration con=new Configuration().configure().addAnnotatedClass(Flight.class);
    	@SuppressWarnings("deprecation")
		SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	
    	session.save(f);
    	 
    	tx.commit();
    	session.close();
    	sf.close();
	}
	
	public static List<Flight> getFlights(String dep,String arr,String date){
		Configuration con=new Configuration().configure().addAnnotatedClass(Flight.class);
    	@SuppressWarnings("deprecation")
		SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	
    	
         String hql = "from Flight where dep_loc=:dep_loc and arr_loc=:arr_loc";
         Query query = session.createQuery(hql);
         query.setParameter("dep_loc", dep);
         query.setParameter("arr_loc", arr);
  
    	
    	
    	
    	
    	List<Flight> res=query.list();
    	 
    	tx.commit();
    	session.close();
    	sf.close();
    	return res;
	}
}
