package view;

import controller.AtendenteController;
import controller.ConversaController;
import model.vo.*;

import java.util.Scanner;

public class AtendenteView {

    private AtendenteController controller;
    private ConversaView conversaView;
    private ConversaController conversaController;

    public AtendenteView() {
        controller = new AtendenteController();
        conversaView = new ConversaView();
        conversaController = new ConversaController();
    }

    // ---------------- MÉTODOS AUXILIARES ----------------

    private void atualizarStatusTicket(int idTicket, String status) {
        Ticket ticket = new Ticket(idTicket);
        Conversa conversa = new Conversa();
        conversa.setTicket(ticket);
        conversa.setStatus(status);
        conversaController.atualizarStatusTicket(conversa);
    }

    private int exibirSubMenu(String titulo, String... opcoes) {
        System.out.println("------------------------------------------------------");
        System.out.println(titulo);
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + " - " + opcoes[i]);
        }
        System.out.print("Sua opção: ");
        return new Scanner(System.in).nextInt();
    }

    // ---------------- CRUD ATENDENTE ----------------

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

    public void atualizarAtendente(Atendente atendente){
        controller.atualizar(atendente);
    }

    // ---------------- MENU ----------------

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
                    if (conversaView.listarConversas()) {
                        int opcaoTodos = exibirSubMenu("Opções", "Responder Ticket");
                        if (opcaoTodos == 1) {
                            System.out.print("Digite o ID do Ticket que deseja responder: ");
                            int idTicket = sc.nextInt();
                            sc.nextLine(); // consumir quebra de linha
                            System.out.print("Digite sua resposta: ");
                            sc.nextLine(); // resposta ignorada por enquanto
                            atualizarStatusTicket(idTicket, "Em andamento");
                            System.out.println("Resposta enviada com sucesso!");
                        }
                    }
                    break;

                case 2:
                    System.out.println("--- Listando Tickets em aberto ---");
                    if (conversaView.listarConversasPorStatus("Em aberto")) {
                        int opcaoAbertos = exibirSubMenu("Opções", "Responder Ticket");
                        if (opcaoAbertos == 1) {
                            System.out.print("Digite o ID do Ticket que deseja responder: ");
                            int idTicket = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Digite sua resposta: ");
                            sc.nextLine();
                            atualizarStatusTicket(idTicket, "Em andamento");
                            System.out.println("Resposta enviada com sucesso!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("--- Listando Tickets em andamento ---");
                    if (conversaView.listarConversasPorStatus("Em andamento")) {
                        System.out.print("Deseja finalizar um Ticket? (S/N): ");
                        String opcaoFinalizar = sc.next().trim().toUpperCase();
                        if (opcaoFinalizar.equals("S")) {
                            System.out.print("Digite o ID do Ticket que deseja finalizar: ");
                            int idTicketFinalizar = sc.nextInt();
                            atualizarStatusTicket(idTicketFinalizar, "Resolvido");
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
