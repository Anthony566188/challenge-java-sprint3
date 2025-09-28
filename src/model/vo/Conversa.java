package model.vo;

import java.time.LocalDateTime;

public class Conversa {

    private Atendente atendente;
    private Ticket ticket;
    private String nome_ticket;
    //private boolean anexo_ticket;
    private String descricao_ticket;
    private String status;
    private LocalDateTime data_e_hora;
    //private String conversa;


    public Conversa(Atendente atendente, Ticket ticket, String nome_ticket, String descricao_ticket, String status, LocalDateTime data_e_hora) {
        this.atendente = atendente;
        this.ticket = ticket;
        this.nome_ticket = nome_ticket;
        this.descricao_ticket = descricao_ticket;
        this.status = status;
        this.data_e_hora = data_e_hora;
    }

    public Conversa(Ticket ticket, String nome_ticket, String descricao_ticket, String status, LocalDateTime data_e_hora) {
        this.ticket = ticket;
        this.nome_ticket = nome_ticket;
        this.descricao_ticket = descricao_ticket;
        this.status = status;
        this.data_e_hora = data_e_hora;
    }

    public Conversa(){

    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getNome_ticket() {
        return nome_ticket;
    }

    public void setNome_ticket(String nome_ticket) {
        this.nome_ticket = nome_ticket;
    }

    public String getDescricao_ticket() {
        return descricao_ticket;
    }

    public void setDescricao_ticket(String descricao_ticket) {
        this.descricao_ticket = descricao_ticket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getData_e_hora() {
        return data_e_hora;
    }

    public void setData_e_hora(LocalDateTime data_e_hora) {
        this.data_e_hora = data_e_hora;
    }


}
