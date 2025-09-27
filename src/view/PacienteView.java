package view;

import controller.*;
import model.vo.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class PacienteView {
    private PacienteController controller;
    private TipoProblemaController tipoProblemaController;
    private TicketController ticketController;
    private ConversaController  conversaController;
    private AtendenteController atendenteController;

    public PacienteView() {
        controller = new PacienteController();
        tipoProblemaController = new TipoProblemaController();
        ticketController = new TicketController();
        conversaController = new ConversaController();
        atendenteController = new AtendenteController();
    }

    public void inserirPaciente(Paciente paciente) {
        controller.inserir(paciente);
    }

    public void listarPaciente() {
        System.out.println("Listando Pacientes...");
        for (Paciente paciente : controller.listar()) {
            System.out.println("-----------------------------------------------------");
            System.out.println("ID: " + paciente.getId());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Rg: " + paciente.getRg());
            System.out.println("Data de nascimento: " + paciente.getDataNascimento());
            System.out.println("Endereço:  " + paciente.getEndereco());
        }
    }

    public void excluirPaciente(int id){
        controller.excluir(id);
    }

    public void exibirMenuPaciente(Paciente paciente, Consulta consulta) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("--- Menu do Paciente ---");
            System.out.println("1 - Criar Ticket");
            System.out.println("2 - Excluir Ticket");
            System.out.println("3 - Ver meus Tickets");
            System.out.println("4 - Atualizar Ticket");
            System.out.println("0 - Sair");
            System.out.print("Sua opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    List<TipoProblema> tiposProblemas = tipoProblemaController.listar();

                    System.out.println("--- Tipos de Problemas ---");
                    for (int i = 0; i < tiposProblemas.size(); i++) {
                        System.out.println((i + 1) + " - " + tiposProblemas.get(i).getNome());
                    }

                    System.out.print("Selecione o tipo de problema: ");
                    int opcaoTipoProblema = sc.nextInt();
                    sc.nextLine();

                    // Validar opção escolhida
                    if (opcaoTipoProblema > 0 && opcaoTipoProblema <= tiposProblemas.size()) {

                        // 1. Cria o ticket e recupera o id
                        Ticket novoTicket = new Ticket(paciente, tiposProblemas.get(opcaoTipoProblema - 1), consulta);
                        int idTicket = ticketController.inserir(novoTicket);
                        novoTicket.setId(idTicket);

                        List<Atendente> atendentes = atendenteController.listar();
                        Atendente atendenteSelecionado = atendentes.get(0);

                        System.out.print("Digite o título do ticket: ");
                        String titulo = sc.nextLine();

                        System.out.print("Faça a descrição do seu problema: ");
                        String descricao =  sc.nextLine();



                        conversaController.inserir(new Conversa(atendenteSelecionado, novoTicket, titulo, descricao, "Em aberto", LocalDateTime.now()));
                        //ticketController.inserir(new Ticket(paciente, tiposProblemas.get(opcaoTipoProblema - 1), consulta));


                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2: {
                    List<Ticket> tickets = ticketController.listarTicketsPorPaciente(paciente.getId());
                    if (tickets.isEmpty()) {
                        System.out.println("Nenhum ticket encontrado!");
                    } else {
                        mostrarTickets(tickets);
                        System.out.print("Selecione o número do Ticket que deseja excluir: ");
                        int opcaoExcluir = sc.nextInt();
                        if (opcaoExcluir > 0 && opcaoExcluir <= tickets.size()) {
                            Ticket ticketSelecionado = tickets.get(opcaoExcluir - 1);
                            conversaController.excluir(ticketSelecionado.getId());
                            ticketController.excluir(ticketSelecionado.getId());
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }
                    break;
                }

                case 3: {
                    List<Ticket> tickets = ticketController.listarTicketsPorPaciente(paciente.getId());
                    mostrarTickets(tickets);
                    break;
                }

                case 4: {
                    List<Ticket> tickets = ticketController.listarTicketsPorPaciente(paciente.getId());
                    if (tickets.isEmpty()) {
                        System.out.println("Nenhum ticket encontrado!");
                    } else {
                        mostrarTickets(tickets);
                        System.out.print("Digite o número do Ticket que deseja atualizar: ");
                        int opcaoAtualizar = sc.nextInt();
                        if (opcaoAtualizar > 0 && opcaoAtualizar <= tickets.size()) {
                            Ticket ticketSelecionado = tickets.get(opcaoAtualizar - 1);
                            // Aqui você chamaria ticketController.atualizar(ticketSelecionado)
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }
                    break;
                }

                case 0:
                    System.out.println("Saindo do menu do paciente...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private void mostrarTickets(List<Ticket> tickets) {
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket encontrado!");
        } else {
            System.out.println("Tickets disponíveis:");
            for (int i = 0; i < tickets.size(); i++) {
                System.out.println((i + 1) + " - Ticket ID: " + tickets.get(i).getId());
            }
        }
    }
}
