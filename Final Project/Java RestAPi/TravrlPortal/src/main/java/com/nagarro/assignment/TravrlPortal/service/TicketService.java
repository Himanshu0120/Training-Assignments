package com.nagarro.assignment.TravrlPortal.service;

import java.util.List;

import com.nagarro.assignment.TravrlPortal.model.Ticket;

public interface TicketService {
	
	List<Ticket> getAll();
	
	Ticket submitTicket(Ticket t);
	
	List<Ticket> getById(int id);
	
	public void update(String status, int id, String comment);
	
	public Ticket getbyTicketId(int id);

}
