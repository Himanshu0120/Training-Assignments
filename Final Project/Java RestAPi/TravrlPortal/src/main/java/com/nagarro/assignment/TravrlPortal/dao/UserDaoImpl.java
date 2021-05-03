package com.nagarro.assignment.TravrlPortal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.assignment.TravrlPortal.model.User;



@Repository
@Transactional
public  class UserDaoImpl implements UserDao {
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<User> get() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<User> q=currentSession.createQuery("from User",User.class);
		List<User> res=q.list();
		User u =new User();
	
		return res;
	}

	

	@Override
	public User registerUser(User u) {
		// TODO Auto-generated method stub
		u.setEmail(u.getEmail().toLowerCase());
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(u);
		return u;
	}

	@Override
	public String updatePassword() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String validateUser(String username, String password) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<User> q=currentSession.createQuery("from User where email=:e and password=:p");
		q.setParameter("e", username);
		q.setParameter("p", password);
		System.out.println(username+"   "+password);
		if(q.list().size()==0){
			System.out.println("wrong");
			return "false";
		}
		else {
			return "true";
		}
		
	}



	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query<User> q=currentSession.createQuery("from User where email=:e");
		q.setParameter("e", username);
		User res=q.getSingleResult();
		return res;
		

	}



	@Override
	public String resetPassword(String email, String password) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query q=currentSession.createQuery("update User set password=:p where email=:e");
		q.setParameter("p",password);
		q.setParameter("e", email);
		q.executeUpdate();
		return "Password Update";
	}

	



	

}
