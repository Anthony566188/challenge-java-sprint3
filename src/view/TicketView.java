package view;

import controller.ConsultaController;
import controller.PacienteController;
import controller.TicketController;
import controller.TipoProblemaController;
import model.vo.Ticket;

public class TicketView {

    private TicketController controller;
    private PacienteController pacienteController;
    private TipoProblemaController tipoProblemaController;
    private ConsultaController consultaController;

    public TicketView(){
        controller = new TicketController();
        pacienteController = new PacienteController();
        tipoProblemaController = new TipoProblemaController();
        consultaController = new ConsultaController();
    }

    public void listarTickets(){
        System.out.println("Listando Tickets...");
        for (Ticket ticket : controller.listar()) {
            System.out.println("-----------------------------------------------------");
            System.out.println("ID do Ticket: " + ticket.getId());
            System.out.println("ID do Paciente: " + ticket.getPaciente().getId());
            System.out.println("ID do Tipo de Problema: " + ticket.getTipoProblema().getId());
            System.out.println("ID da Consulta: " + ticket.getConsulta().getId());
        }
    }

    public void excluirTicket(int id){
        controller.excluir(id);
    }

}
