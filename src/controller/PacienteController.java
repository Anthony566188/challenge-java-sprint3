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

    public void exibirMenuPaciente(Paciente paciente, Consulta consulta){
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("--- Menu do Paciente ---");
        System.out.println("1 - Criar Ticket");
        System.out.println("0 - Sair");
        System.out.print("Sua opção: ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                TipoProblema tipoEscolhido = tipoProblemaView.listarTiposProblemas();


                if (tipoEscolhido != null) {
                    ticketDAO.inserirTicket(new Ticket(paciente, tipoEscolhido, consulta));
                }
                break;
            case 0:
                System.out.println("Saindo do menu do paciente...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }

}
