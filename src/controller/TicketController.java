package controller;

import model.dao.TicketDAO;
import model.vo.Ticket;

import java.util.List;

public class TicketController {

    private TicketDAO ticketDAO;

    public TicketController(){
        ticketDAO = new TicketDAO();
    }

    public void inserir(Ticket ticket){
        ticketDAO.inserirTicket(ticket);
    }

    public List<Ticket> listar(){
        return ticketDAO.listarTickets();
    }
    public List<Ticket> listarTicketsPorPaciente(int idPaciente){
        return ticketDAO.listarTicketsPorPaciente(idPaciente);
    }

    public List<Ticket> listarTicketsPorTipoProblema(int idProblema){
        return ticketDAO.listarTicketsPorTipoProblema(idProblema);
    }

    public void excluir(int id){
        ticketDAO.excluirTicket(id);
    }

}
