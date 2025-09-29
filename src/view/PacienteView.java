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
    private ConversaController conversaController;
    private AtendenteController atendenteController;

    public PacienteView() {
        controller = new PacienteController();
        tipoProblemaController = new TipoProblemaController();
        ticketController = new TicketController();
        conversaController = new ConversaController();
        atendenteController = new AtendenteController();
    }

    // ---------------- MÉTODOS AUXILIARES ----------------

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

    private Ticket selecionarTicketPaciente(Paciente paciente) {
        List<Ticket> tickets = ticketController.listarTicketsPorPaciente(paciente.getId());
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket encontrado!");
            return null;
        }
        mostrarTickets(tickets);
        System.out.print("Selecione o número do Ticket: ");
        int opcao = new Scanner(System.in).nextInt();
        if (opcao > 0 && opcao <= tickets.size()) {
            return tickets.get(opcao - 1);
        }
        System.out.println("Opção inválida.");
        return null;
    }

    // ---------------- CRUD PACIENTE ----------------

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
            System.out.println("Endereço: " + paciente.getEndereco());
        }
    }

    public void excluirPaciente(int id){
        controller.excluir(id);
    }

    public void atualizarPaciente(Paciente paciente){
        controller.atualizar(paciente);
    }

    // ---------------- MENU ----------------

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
                case 1: // Criar Ticket
                    List<TipoProblema> tiposProblemas = tipoProblemaController.listar();
                    System.out.println("--- Tipos de Problemas ---");
                    for (int i = 0; i < tiposProblemas.size(); i++) {
                        System.out.println((i + 1) + " - " + tiposProblemas.get(i).getNome());
                    }

                    System.out.print("Selecione o tipo de problema: ");
                    int opcaoTipoProblema = sc.nextInt();
                    sc.nextLine();

                    if (opcaoTipoProblema > 0 && opcaoTipoProblema <= tiposProblemas.size()) {
                        Ticket novoTicket = new Ticket(paciente, tiposProblemas.get(opcaoTipoProblema - 1), consulta);
                        int idTicket = ticketController.inserir(novoTicket);
                        novoTicket.setId(idTicket);

                        List<Atendente> atendentes = atendenteController.listar();
                        Atendente atendenteSelecionado = atendentes.get(0); // por enquanto o 1º

                        System.out.print("Digite o título do ticket: ");
                        String titulo = sc.nextLine();
                        System.out.print("Faça a descrição do seu problema: ");
                        String descricao = sc.nextLine();

                        conversaController.inserir(
                                new Conversa(atendenteSelecionado, novoTicket, titulo, descricao, "Em aberto", LocalDateTime.now())
                        );
                        System.out.println("✅ Ticket criado com sucesso!");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2: { // Excluir Ticket
                    Ticket ticketExcluir = selecionarTicketPaciente(paciente);
                    if (ticketExcluir != null) {
                        conversaController.excluir(ticketExcluir.getId());
                        ticketController.excluir(ticketExcluir.getId());
                        System.out.println("✅ Ticket excluído com sucesso!");
                    }
                    break;
                }

                case 3: { // Ver Tickets
                    List<Ticket> tickets = ticketController.listarTicketsPorPaciente(paciente.getId());
                    mostrarTickets(tickets);
                    break;
                }

                case 4: { // Atualizar Ticket
                    Ticket ticketAtualizar = selecionarTicketPaciente(paciente);
                    if (ticketAtualizar != null) {
                        sc.nextLine(); // consumir quebra
                        System.out.print("Digite o título do Ticket: ");
                        String titulo = sc.nextLine();
                        System.out.print("Digite a descrição do Ticket: ");
                        String descricao = sc.nextLine();

                        Conversa conversa = new Conversa();
                        conversa.setTicket(ticketAtualizar);
                        conversa.setNome_ticket(titulo);
                        conversa.setDescricao_ticket(descricao);
                        conversa.setData_e_hora(LocalDateTime.now());

                        conversaController.pacienteAtualizarTicket(conversa);
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
}
