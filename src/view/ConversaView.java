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

    public void listarConversas(){
        for (Conversa conversa : controller.listar()) {
            System.out.println("-----------------------------------------------------");
            System.out.println("ID do Ticket: " + conversa.getTicket().getId());
            System.out.println("Título: " + conversa.getNome_ticket());
            System.out.println("Descrição: " + conversa.getDescricao_ticket());
            System.out.println("Status: " + conversa.getStatus());
            System.out.println("Data de hora: " + conversa.getData_e_hora());
        }
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

        return encontrou; // devolve se achou ou não
    }



//    public void mostrarConversas(List<Conversa> conversas) {
//        if (conversas.isEmpty()) {
//            System.out.println("Nenhum ticket encontrado!");
//        } else {
//            System.out.println("Tickets disponíveis:");
//            for (int i = 0; i < conversas.size(); i++) {
//                System.out.println((i + 1) + " - Ticket ID: " + conversas.get(i).getTicket().getId());
//                System.out.println("Título: " + conversas.get(i).getNome_ticket());
//                System.out.println("Descrição: " + conversas.get(i).getDescricao_ticket());
//                System.out.println("Status: " + conversas.get(i).getStatus());
//                System.out.println("Data de hora: " + conversas.get(i).getData_e_hora());
//            }
//        }
//    }

}
