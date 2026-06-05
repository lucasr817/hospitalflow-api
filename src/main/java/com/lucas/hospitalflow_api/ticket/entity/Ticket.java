package com.lucas.hospitalflow_api.ticket.entity;

import com.lucas.hospitalflow_api.ticket.enums.TicketStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String numeroSenha;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroSenha() {
        return numeroSenha;
    }

    public void setNumeroSenha(String numeroSenha) {
        this.numeroSenha = numeroSenha;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
