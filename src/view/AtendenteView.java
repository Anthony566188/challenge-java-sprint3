package view;

import controller.AtendenteController;
import controller.TicketController;
import model.vo.Atendente;
import model.vo.Paciente;

import java.util.Scanner;

public class AtendenteView {

    private AtendenteController controller;
    private TicketView ticketView;

    public AtendenteView() {
        controller = new AtendenteController();
        ticketView = new TicketView();
    }

    public void inserirAtendente(Atendente atendente){
        controller.inserir(atendente);
    }

    public void listarAtendentes(){
        System.out.println("Listando atendentes...");
        for (Atendente atendente : controller.listar()) {
            System.out.println("------------------------------------------");
            System.out.println("ID: " + atendente.getId());
            System.out.println("Nome: " + atendente.getNome());
            System.out.println("Email: " + atendente.getEmail());
        }

    }

    public void exibirMenuAtendente(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("--- Menu do Atendente ---");
        System.out.println("1 - Ver Tickets");
        System.out.println("0 - Sair");
        System.out.print("Sua opção: ");
        opcao = sc.nextInt();


        switch (opcao) {
            case 1:
                ticketView.listarTickets();
                break;
            case 0:
                System.out.println("Saindo do menu do Atendente...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }

}
