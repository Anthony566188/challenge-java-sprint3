package controller;

import model.dao.TicketDAO;
import model.vo.Ticket;

public class TicketController {

    private TicketDAO ticketDAO;

    public TicketController(){
        ticketDAO = new TicketDAO();
    }

    public void inserir(Ticket ticket){
        ticketDAO.inserirTicket(ticket);
    }
}
