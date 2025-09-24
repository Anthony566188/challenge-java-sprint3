package view;

import controller.AtendenteController;
import controller.TicketController;
import controller.TipoProblemaController;
import model.vo.*;

import java.util.List;
import java.util.Scanner;

public class AtendenteView {

    private AtendenteController controller;
    private TicketView ticketView;
    private TicketController ticketController;
    private TipoProblemaController tipoProblemaController;

    public AtendenteView() {
        controller = new AtendenteController();
        ticketView = new TicketView();
        ticketController = new TicketController();
        tipoProblemaController = new TipoProblemaController();
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

    public void exibirMenuAtendente() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("--- Menu do Atendente ---");
            System.out.println("1 - Ver Tickets");
            System.out.println("0 - Sair");
            System.out.print("Sua opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    ticketView.listarTickets();

                    int opcaoTickets;
                    do {
                        System.out.println("-------------------------------------------");
                        System.out.println("1 - Filtrar por Tipo de Problema");
                        System.out.println("0 - Voltar");
                        System.out.print("Sua opção: ");
                        opcaoTickets = sc.nextInt();

                        switch (opcaoTickets) {
                            case 1:
                                List<TipoProblema> tiposProblemas = tipoProblemaController.listar();

                                System.out.println("Tipos de Problemas disponíveis:");
                                for (int i = 0; i < tiposProblemas.size(); i++) {
                                    System.out.println((i + 1) + " - " + tiposProblemas.get(i).getNome());
                                }

                                System.out.print("Selecione o número do Tipo de problema que deseja filtrar: ");
                                int opcaoFiltrar = sc.nextInt();

                                if (opcaoFiltrar > 0 && opcaoFiltrar <= tiposProblemas.size()) {
                                    TipoProblema tipoProblemaSelecionado = tiposProblemas.get(opcaoFiltrar - 1);
                                    List<Ticket> ticketsFiltrados =
                                            ticketController.listarTicketsPorTipoProblema(tipoProblemaSelecionado.getId());

                                    if (ticketsFiltrados.isEmpty()) {
                                        System.out.println("Nenhum ticket encontrado para esse tipo de problema.");
                                    } else {
                                        System.out.println("Tickets filtrados:");
                                        for (Ticket t : ticketsFiltrados) {
                                            System.out.println("Ticket ID: " + t.getId() +
                                                    " | Paciente ID: " + t.getPaciente().getId() +
                                                    " | Tipo: " + tipoProblemaSelecionado.getNome());
                                        }
                                    }
                                } else {
                                    System.out.println("Opção inválida.");
                                }
                                break;

                            case 0:
                                System.out.println("Voltando ao menu do Atendente...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    } while (opcaoTickets != 0);
                    break;

                case 0:
                    System.out.println("Saindo do menu do Atendente...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}
