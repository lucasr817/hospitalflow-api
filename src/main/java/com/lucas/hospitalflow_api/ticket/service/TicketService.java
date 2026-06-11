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


        LocalDateTime inicioDoDia = LocalDateTime.now()
                .toLocalDate()
                .atStartOfDay();

        var ultimoTicket = ticketRepository
                .findTopByDataCriacaoAfterOrderByDataCriacaoDesc(inicioDoDia);

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

    public Ticket chamarProximaSenha() {

        var ticket = ticketRepository
                .findFirstByStatusOrderByDataCriacaoAsc(TicketStatus.AGUARDANDO);

        if (ticket.isEmpty()) {
            throw new RuntimeException("Nenhuma senha aguardando atendimento");
        }

        Ticket ticketEncontrado = ticket.get();
        ticketEncontrado.setStatus(TicketStatus.CHAMADO);
        return ticketRepository.save(ticketEncontrado);

    }
    public Ticket finalizarAtendimento(Long id) {
        var ticket = ticketRepository.findById(id);

        if (ticket.isEmpty()) {
            throw new RuntimeException("Ticket não encontrado ");
        }

        Ticket ticketEncontrado = ticket.get();

        ticketEncontrado.setStatus(TicketStatus.FINALIZADO);
        ticketEncontrado.setDataFinalizacao(LocalDateTime.now());

        return ticketRepository.save(ticketEncontrado);

    }
}
