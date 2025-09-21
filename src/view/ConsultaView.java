package view;

import controller.ConsultaController;
import controller.MedicoController;
import controller.PacienteController;
import model.vo.Consulta;
import model.vo.Medico;
import model.vo.Paciente;

import java.time.LocalDateTime;
import java.util.List;

public class ConsultaView {

    private ConsultaController controller;
    private PacienteController pacienteController;
    private MedicoController medicoController;

    public ConsultaView() {
        controller = new ConsultaController();
        pacienteController = new PacienteController();
        medicoController = new MedicoController();
    }

    public void inserirConsulta() {
        List<Paciente> pacientes = pacienteController.listar();
        Paciente pacienteSelecionado = pacientes.get(0);

        List<Medico> medicos = medicoController.listar();
        Medico medicoSelecionado = medicos.get(0);

        controller.inserir(new Consulta(pacienteSelecionado, medicoSelecionado, LocalDateTime.of(2025, 9, 21, 15, 0), LocalDateTime.of(2025, 9, 21, 16, 0)));
    }

    public void listarConsultas() {
        System.out.println("Listando Consultas...");
        for (Consulta consulta : controller.listar()) {
            System.out.println("------------------------------------------");
            System.out.println("ID: " + consulta.getId());
            System.out.println("ID do Paciente: " + consulta.getPaciente().getId());
            System.out.println("ID do Médico: " + consulta.getMedico().getId());
            System.out.println("Data e hora início: " + consulta.getDataEHoraInicio());
            System.out.println("Data e hora fim: " + consulta.getDataEHoraFim());
        }
    }
}
