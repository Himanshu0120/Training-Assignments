package com.nagarro.assignment.TravrlPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignment.TravrlPortal.dao.TicketDao;
import com.nagarro.assignment.TravrlPortal.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDao ticketDao;

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return ticketDao.getAll();
	}

	@Override
	public Ticket submitTicket(Ticket t) {
		// TODO Auto-generated method stub
		
		return ticketDao.submitTicket(t);
	}

	@Override
	public List<Ticket> getById(int id) {
		// TODO Auto-generated method stub
		return ticketDao.getById(id);
	}

	@Override
	public void update(String status, int id, String comment) {
		// TODO Auto-generated method stub
		ticketDao.update(status, id, comment);
		return;
		
	}

	@Override
	public Ticket getbyTicketId(int id) {
		// TODO Auto-generated method stub
		return ticketDao.getbyTicketId(id);
	}
}
