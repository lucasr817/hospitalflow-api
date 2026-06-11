package com.lucas.hospitalflow_api.ticket.controller;

import com.lucas.hospitalflow_api.ticket.entity.Ticket;
import com.lucas.hospitalflow_api.ticket.service.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket criarSenha() {
        return ticketService.criarSenha();
    }
    @PostMapping("/chamar")
    public Ticket chamarProximaSenha() {
        return ticketService.chamarProximaSenha();
    }
}
