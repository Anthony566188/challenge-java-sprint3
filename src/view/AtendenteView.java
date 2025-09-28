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
    private ConversaView conversaView;

    public AtendenteView() {
        controller = new AtendenteController();
        ticketView = new TicketView();
        ticketController = new TicketController();
        tipoProblemaController = new TipoProblemaController();
        conversaView = new ConversaView();
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
            System.out.println("1 - Ver todos os Tickets");
            System.out.println("2 - Ver Tickets em aberto");
            System.out.println("3 - Ver Tickets em andamento");
            System.out.println("4 - Ver tickets Resolvidos");
            System.out.println("5 - Filtrar Tickets por tipo de problema");
            System.out.println("0 - Sair");
            System.out.print("Sua opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("--- Listando todos os Tickets ---");
                    conversaView.listarConversas();

//                    int opcaoTickets;
//                    do {
//                        System.out.println("-------------------------------------------");
//                        System.out.println("1 - Selecionar Ticket");
//                        System.out.println("2 - Filtrar por Tipo de Problema");
//                        System.out.println("0 - Voltar");
//                        System.out.print("Sua opção: ");
//                        opcaoTickets = sc.nextInt();
//
//                        switch (opcaoTickets) {
//                            case 1:
//                                System.out.println("Digite o ");
//                            case 2:
//                                List<TipoProblema> tiposProblemas = tipoProblemaController.listar();
//
//                                System.out.println("Tipos de Problemas disponíveis:");
//                                for (int i = 0; i < tiposProblemas.size(); i++) {
//                                    System.out.println((i + 1) + " - " + tiposProblemas.get(i).getNome());
//                                }
//
//                                System.out.print("Selecione o número do Tipo de problema que deseja filtrar: ");
//                                int opcaoFiltrar = sc.nextInt();
//
//                                if (opcaoFiltrar > 0 && opcaoFiltrar <= tiposProblemas.size()) {
//                                    TipoProblema tipoProblemaSelecionado = tiposProblemas.get(opcaoFiltrar - 1);
//                                    List<Ticket> ticketsFiltrados =
//                                            ticketController.listarTicketsPorTipoProblema(tipoProblemaSelecionado.getId());
//
//                                    if (ticketsFiltrados.isEmpty()) {
//                                        System.out.println("Nenhum ticket encontrado para esse tipo de problema.");
//                                    } else {
//                                        System.out.println("Tickets filtrados:");
//                                        for (Ticket t : ticketsFiltrados) {
//                                            System.out.println("Ticket ID: " + t.getId() +
//                                                    " | Paciente ID: " + t.getPaciente().getId() +
//                                                    " | Tipo: " + tipoProblemaSelecionado.getNome());
//                                        }
//                                    }
//                                } else {
//                                    System.out.println("Opção inválida.");
//                                }
//                                break;
//                            case 0:
//                                System.out.println("Voltando ao menu do Atendente...");
//                                break;
//
//                            default:
//                                System.out.println("Opção inválida.");
//                                break;
//                        }
//                    } while (opcaoTickets != 0);
                    break;
                case 2:
                    System.out.println("--- Listando Tickets em aberto ---");
                    conversaView.listarConversasPorStatus("Em aberto");
                    break;
                case 5:
                    List<TipoProblema> tiposProblemas = tipoProblemaController.listar();
//
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
                            System.out.println("-----------------------------------------------------------");
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
                    System.out.println("Saindo do menu do Atendente...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}
