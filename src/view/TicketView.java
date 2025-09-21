package view;

import controller.ConsultaController;
import controller.PacienteController;
import controller.TicketController;
import controller.TipoProblemaController;
import model.vo.Consulta;
import model.vo.Paciente;
import model.vo.Ticket;
import model.vo.TipoProblema;

import java.util.List;

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

    public void criarTicket(){
        List<Paciente> pacientes = pacienteController.listar();
        List<TipoProblema> tiposProblemas = tipoProblemaController.listar();
        List<Consulta> consultas = consultaController.listar();

        Paciente pacienteSelecionado = pacientes.get(0);
        TipoProblema tipoProblemaSelecionado = tiposProblemas.get(0);
        Consulta consultaSelecionada = consultas.get(0);

        controller.inserir(new Ticket(pacienteSelecionado, tipoProblemaSelecionado, consultaSelecionada));
    }

}
