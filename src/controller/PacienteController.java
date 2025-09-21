package controller;

import model.dao.PacienteDAO;
import model.dao.TicketDAO;
import model.vo.Paciente;

import java.util.List;
import java.util.Scanner;

public class PacienteController {

    private PacienteDAO pacienteDAO;
    private TicketDAO ticketDAO;

    public PacienteController() {
        pacienteDAO = new PacienteDAO();
        ticketDAO = new TicketDAO();
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

    public void exibirMenuPaciente(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("--- Menu do Paciente ---");
        System.out.println("1 - Criar Ticket");
        System.out.println("0 - Sair");
        System.out.print("Sua opção: ");
        opcao = sc.nextInt();

//        switch (opcao) {
//            case 1:
//
//                break;
//            case 0:
//                System.out.println("Saindo do menu do paciente...");
//                break;
//            default:
//                System.out.println("Opção inválida. Por favor, tente novamente.");
//                break;
//        }
    }

}
