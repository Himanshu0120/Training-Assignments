package com.nagarro.assignment.TravrlPortal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment.TravrlPortal.model.Ticket;
import com.nagarro.assignment.TravrlPortal.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("")
	public List<Ticket> getAll() {
		return ticketService.getAll();
	}
	
	
	@PostMapping("")
	public Ticket submitTicket(@RequestBody Ticket t) {
		return ticketService.submitTicket(t);
	}
	
	@GetMapping("/{id}")
	public List<Ticket> getById(@PathVariable String id){
		int temp=Integer.parseInt(id);
		return ticketService.getById(temp);
	}
	
	@PostMapping("/updateStatus")
	public Map<String, Object> update(@RequestBody Map<String,Object> input) {
		int id=(int) input.get("id");
		String status=(String) input.get("status");
		String comment=(String) input.get("comment");
		ticketService.update(status, id, comment);
		return input;
	}
	
	
	@GetMapping("id/{id}")
	public Ticket getbyTicketId(@PathVariable String id) {
		int temp=Integer.parseInt(id);
		return ticketService.getbyTicketId(temp);
	}
}
