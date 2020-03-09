package com.springWithJpa.springBootWithJpa.TicketDao;

import org.springframework.data.repository.CrudRepository;

import com.springWithJpa.springBootWithJpa.model.Ticket;

public interface TicketDao extends CrudRepository<Ticket, Integer>
{

}
