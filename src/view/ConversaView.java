package view;

import controller.ConversaController;
import model.vo.Conversa;
import model.vo.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class ConversaView {

    private ConversaController controller;

    public ConversaView(){
        controller = new ConversaController();
    }

//    public void listarConversas(){
//        for (Conversa conversa : controller.listar()) {
//            System.out.println("-----------------------------------------------------");
//            System.out.println("ID do Ticket: " + conversa.getTicket().getId());
//            System.out.println("Título: " + conversa.getNome_ticket());
//            System.out.println("Descrição: " + conversa.getDescricao_ticket());
//            System.out.println("Status: " + conversa.getStatus());
//            System.out.println("Data de hora: " + conversa.getData_e_hora());
//        }
//    }

    public boolean listarConversas() {
        boolean encontrou = false;

        List<Conversa> listaConversas = controller.listar();

        if (!listaConversas.isEmpty()) {
            encontrou = true;

            for (Conversa conversa : listaConversas) {
                System.out.println("-----------------------------------------------------");
                System.out.println("ID do Ticket: " + conversa.getTicket().getId());
                System.out.println("Título: " + conversa.getNome_ticket());
                System.out.println("Descrição: " + conversa.getDescricao_ticket());
                System.out.println("Status: " + conversa.getStatus());
                System.out.println("Data e hora: " + conversa.getData_e_hora());
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum ticket encontrado");
        }

        return encontrou;
    }

    public boolean listarConversasPorStatus(String status) {
        boolean encontrou = false;

        for (Conversa conversa : controller.listar()) {
            if (conversa.getStatus().equalsIgnoreCase(status)) {
                encontrou = true;
                System.out.println("-----------------------------------------------------");
                System.out.println("ID do Ticket: " + conversa.getTicket().getId());
                System.out.println("Título: " + conversa.getNome_ticket());
                System.out.println("Descrição: " + conversa.getDescricao_ticket());
                System.out.println("Status: " + conversa.getStatus());
                System.out.println("Data e hora: " + conversa.getData_e_hora());
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum ticket encontrado com status: " + status);
        }

        return encontrou;
    }

    public void excluirConversa(int id) {
        controller.excluir(id);
    }
}
