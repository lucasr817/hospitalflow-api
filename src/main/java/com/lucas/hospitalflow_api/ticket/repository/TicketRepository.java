package com.lucas.hospitalflow_api.ticket.repository;

import com.lucas.hospitalflow_api.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TicketRepository  extends JpaRepository<Ticket,Long> {

    Optional<Ticket> findTopByOrderByIdDesc();

}
