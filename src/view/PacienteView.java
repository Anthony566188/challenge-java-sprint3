package view;

import controller.PacienteController;
import controller.TicketController;
import model.vo.Consulta;
import model.vo.Paciente;
import model.vo.Ticket;
import model.vo.TipoProblema;

import java.util.List;
import java.util.Scanner;

public class PacienteView {
    private PacienteController controller;
    private TipoProblemaView tipoProblemaView;
    private TicketController ticketController;

    public PacienteView() {
        controller = new PacienteController();
        tipoProblemaView = new TipoProblemaView();
        ticketController = new TicketController();
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

    public void exibirMenuPaciente(Paciente paciente, Consulta consulta){
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("--- Menu do Paciente ---");
        System.out.println("1 - Criar Ticket");
        System.out.println("2 - Excluir Ticket");
        System.out.println("3 - Ver meus Tickets");
        System.out.println("4 - Atualizar Ticket");
        System.out.println("0 - Sair");
        System.out.print("Sua opção: ");
        opcao = sc.nextInt();

        List<Ticket> tickets = ticketController.listarTicketsPorPaciente(paciente.getId());
        switch (opcao) {
            case 1:
                TipoProblema tipoEscolhido = tipoProblemaView.listarTiposProblemas();


                if (tipoEscolhido != null) {
                    ticketController.inserir(new Ticket(paciente, tipoEscolhido, consulta));
                }
                break;
            case 2:
                /*
                 * Aqui chama o método listarTicketsPorPaciente() e passa como parâmetro o id do paciente que
                 * foi passado como parâmetro no método exibirMenuPaciente()
                 * */


                if (tickets.isEmpty()) {
                    System.out.println("Nenhum ticket encontrado!.");
                } else {
                    System.out.println("Tickets disponíveis:");
                    for (int i = 0; i < tickets.size(); i++) {
                        System.out.println((i + 1) + " - Ticket ID: " + tickets.get(i).getId());
                    }

                    System.out.print("Selecione o número do Ticket que deseja excluir: ");
                    int opcaoExcluir = sc.nextInt();

                    if (opcaoExcluir > 0 && opcaoExcluir <= tickets.size()) {
                        Ticket ticketSelecionado = tickets.get(opcaoExcluir - 1);
                        ticketController.excluir(ticketSelecionado.getId());
                    } else {
                        System.out.println("Opção inválida.");
                    }

                }
                break;
            case 3:
                if (tickets.isEmpty()) {
                    System.out.println("Nenhum ticket encontrado!.");
                } else {
                    System.out.println("Tickets disponíveis:");
                    for (int i = 0; i < tickets.size(); i++) {
                        System.out.println((i + 1) + " - Ticket ID: " + tickets.get(i).getId());
                    }
                }
                break;
            case 4:
                if (tickets.isEmpty()) {
                    System.out.println("Nenhum ticket encontrado!.");
                } else {
                    System.out.println("Tickets disponíveis:");
                    for (int i = 0; i < tickets.size(); i++) {
                        System.out.println((i + 1) + " - Ticket ID: " + tickets.get(i).getId());
                    }

                    System.out.print("Digite o número do Ticket que deseja atualizar: ");
                    int opcaoAtualizar = sc.nextInt();
                    break;
                }
            case 0:
                System.out.println("Saindo do menu do paciente...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }

}
