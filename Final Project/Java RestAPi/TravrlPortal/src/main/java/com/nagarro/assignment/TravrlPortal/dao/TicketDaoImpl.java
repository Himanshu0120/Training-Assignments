package com.nagarro.assignment.TravrlPortal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.assignment.TravrlPortal.model.Ticket;


@Repository
@Transactional
public class TicketDaoImpl implements TicketDao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Ticket> q=currentSession.createQuery("from Ticket",Ticket.class);
		return q.list();
	}

	@Override
	public Ticket submitTicket(Ticket t) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(t);
		return t;
	}

	@Override
	public List<Ticket> getById(int id) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Ticket> q=currentSession.createQuery("from Ticket where uid=:i",Ticket.class);
		q.setParameter("i", id);
		return q.list();
		
	}

	@Override
	public void update(String status, int id, String comment) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Ticket> q=currentSession.createQuery("update Ticket set status=:s , comments=:c where tid=:i");
		q.setParameter("s", status);
		q.setParameter("c", comment);
		q.setParameter("i", id);
		q.executeUpdate();
		return;
		
	}

	@Override
	public Ticket getbyTicketId(int id) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Ticket> q=currentSession.createQuery("from Ticket where tid=:i",Ticket.class);
		q.setParameter("i", id);
		return q.uniqueResult();
	}
	
	

}
