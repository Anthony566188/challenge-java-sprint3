package view;

import controller.AtendenteController;
import controller.ConversaController;
import controller.TicketController;
import controller.TipoProblemaController;
import model.vo.*;

import java.util.Scanner;

public class AtendenteView {

    private AtendenteController controller;
    private TicketView ticketView;
    private TicketController ticketController;
    private TipoProblemaController tipoProblemaController;
    private ConversaView conversaView;
    private ConversaController conversaController;

    public AtendenteView() {
        controller = new AtendenteController();
        ticketView = new TicketView();
        ticketController = new TicketController();
        tipoProblemaController = new TipoProblemaController();
        conversaView = new ConversaView();
        conversaController = new ConversaController();
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
            System.out.println("0 - Sair");
            System.out.print("Sua opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("--- Listando todos os Tickets ---");
                    conversaView.listarConversas();

                    System.out.println("------------------------------------------------------");
                    System.out.println("1 - Responder Ticket");
                    System.out.print("Sua opcao: ");
                    int opcaoTodosTicket = sc.nextInt();

                    switch (opcaoTodosTicket){
                        case 1:
                            System.out.print("Digite o ID do Ticket que deseja responder: ");
                            int idTicket = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Digite sua resposta: ");
                            String resposta = sc.nextLine();


                            Ticket ticket = new Ticket(idTicket);
                            Conversa conversa = new Conversa();
                            conversa.setTicket(ticket);
                            conversa.setStatus("Em andamento");

                            conversaController.atualizarStatusTicket(conversa);

                            System.out.println("Resposta enviada com sucesso!");

                            break;
                    }
                    break;
                case 2:
                    System.out.println("--- Listando Tickets em aberto ---");
                    boolean temTicketsAbertos = conversaView.listarConversasPorStatus("Em aberto");

                    if (temTicketsAbertos) {
                        System.out.println("------------------------------------------------------");
                        System.out.println("1 - Responder Ticket");
                        System.out.print("Sua opcao: ");
                        int opcaoTicketsAbertos = sc.nextInt();

                        switch (opcaoTicketsAbertos) {
                            case 1:
                                System.out.print("Digite o ID do Ticket que deseja responder: ");
                                int idTicket = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Digite sua resposta: ");
                                String resposta = sc.nextLine();

                                Ticket ticket = new Ticket(idTicket);
                                Conversa conversa = new Conversa();
                                conversa.setTicket(ticket);
                                conversa.setStatus("Em andamento");

                                conversaController.atualizarStatusTicket(conversa);

                                System.out.println("Resposta enviada com sucesso!");
                                break;

                            default:
                                System.out.println("Opção inválida. Por favor, tente novamente.");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("--- Listando Tickets em andamento ---");
                    boolean temTicketsAndamento = conversaView.listarConversasPorStatus("Em andamento");

                    if (temTicketsAndamento) {
                        System.out.println("------------------------------------------------------");
                        System.out.print("Deseja finalizar um Ticket? (S/N): ");
                        String opcaoFinalizar = sc.next().trim().toUpperCase();

                        if (opcaoFinalizar.equals("S")) {
                            System.out.print("Digite o ID do Ticket que deseja finalizar: ");
                            int idTicketFinalizar = sc.nextInt();

                            Ticket ticket = new Ticket(idTicketFinalizar);
                            Conversa conversa = new Conversa();
                            conversa.setTicket(ticket);
                            conversa.setStatus("Resolvido");

                            conversaController.atualizarStatusTicket(conversa);

                            System.out.println("Ticket finalizado com sucesso!");
                        } else {
                            System.out.println("Voltando ao menu do atendente...");
                        }
                    }
                    break;
                case 4:
                    System.out.println("--- Listando Tickets Resolvidos ---");
                    conversaView.listarConversasPorStatus("Resolvido");
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
