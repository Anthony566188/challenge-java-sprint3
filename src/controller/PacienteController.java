package controller;

import model.dao.PacienteDAO;
import model.dao.TicketDAO;
import model.vo.Consulta;
import model.vo.Paciente;
import model.vo.Ticket;
import model.vo.TipoProblema;
import view.TipoProblemaView;

import java.util.List;
import java.util.Scanner;

public class PacienteController {

    private PacienteDAO pacienteDAO;
    private TicketDAO ticketDAO;
    private TipoProblemaView tipoProblemaView;

    public PacienteController() {
        pacienteDAO = new PacienteDAO();
        ticketDAO = new TicketDAO();
        tipoProblemaView = new TipoProblemaView();
    }

    public void inserir(Paciente paciente) {
        pacienteDAO.inserirPaciente(paciente);
    }

    public List<Paciente> listar(){
        return pacienteDAO.listarPacientes();
    }

    public void excluir(int id){
        pacienteDAO.excluirPaciente(id);
    }

}
