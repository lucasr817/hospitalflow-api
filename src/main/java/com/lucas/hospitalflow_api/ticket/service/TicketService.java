package com.lucas.hospitalflow_api.ticket.service;

import com.lucas.hospitalflow_api.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;
import com.lucas.hospitalflow_api.ticket.entity.Ticket;
import com.lucas.hospitalflow_api.ticket.enums.TicketStatus;
import java.time.LocalDateTime;


@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket criarSenha() {
        Ticket ticket = new Ticket();

        var ultimoTicket = ticketRepository.findTopByOrderByIdDesc();
        String novaSenha = "A001";

        if (ultimoTicket.isPresent()) {
            String ultimaSenha = ultimoTicket.get().getNumeroSenha();

            String numeroTexto = ultimaSenha.substring(1);

            int numero = Integer.parseInt(numeroTexto);

            numero++;
            String numeroFormatado = String.format("%03d", numero);

            novaSenha = "A" + numeroFormatado;

        }

        ticket.setNumeroSenha(novaSenha);
        ticket.setStatus(TicketStatus.AGUARDANDO);
        ticket.setDataCriacao(LocalDateTime.now());

        return ticketRepository.save(ticket);

    }
}
