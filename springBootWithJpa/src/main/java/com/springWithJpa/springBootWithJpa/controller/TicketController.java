package com.springWithJpa.springBootWithJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springWithJpa.springBootWithJpa.TicketDao.TicketDao;
import com.springWithJpa.springBootWithJpa.model.Ticket;


@RestController
public class TicketController 
{
	@Autowired
	private TicketDao ticketDao;
	
	@PostMapping("/add")
	public String bookTicket(@RequestBody Ticket tickets)
	{		
			ticketDao.save(tickets);
			return "ticket Booked";
	}
		
	@GetMapping("/get")
	public List<Ticket> getTicket()
	{
		return (List<Ticket>) ticketDao.findAll();
	}
}