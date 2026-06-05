package com.lucas.hospitalflow_api.ticket.service;

import com.lucas.hospitalflow_api.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;
import com.lucas.hospitalflow_api.ticket.entity.Ticket;
import com.lucas.hospitalflow_api.ticket.enums.TicketStatus;


@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket criarSenha() {
        Ticket ticket = new Ticket();

        ticket.setNumeroSenha("A001");
        ticket.setStatus(TicketStatus.AGUARDANDO);

        return ticketRepository.save(ticket);

    }
}
