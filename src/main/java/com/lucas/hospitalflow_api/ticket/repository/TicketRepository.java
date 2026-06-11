package com.lucas.hospitalflow_api.ticket.repository;

import com.lucas.hospitalflow_api.ticket.entity.Ticket;
import com.lucas.hospitalflow_api.ticket.enums.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findTopByOrderByIdDesc();

    Optional<Ticket> findTopByDataCriacaoAfterOrderByDataCriacaoDesc(LocalDateTime data);

    Optional<Ticket> findFirstByStatusOrderByDataCriacaoAsc(TicketStatus status);
}