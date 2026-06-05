package com.lucas.hospitalflow_api.ticket.repository;

import com.lucas.hospitalflow_api.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository  extends JpaRepository<Ticket,Long> {
}
