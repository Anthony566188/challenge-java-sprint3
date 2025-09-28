package view;

import controller.ConversaController;
import model.vo.Conversa;
import model.vo.Ticket;

import java.time.LocalDateTime;

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

    public void listarConversasPorStatus(String status){
        for (Conversa conversa : controller.listar()) {
            if (conversa.getStatus().equalsIgnoreCase(status)) {
                System.out.println("-----------------------------------------------------");
                System.out.println("ID do Ticket: " + conversa.getTicket().getId());
                System.out.println("Título: " + conversa.getNome_ticket());
                System.out.println("Descrição: " + conversa.getDescricao_ticket());
                System.out.println("Status: " + conversa.getStatus());
                System.out.println("Data de hora: " + conversa.getData_e_hora());
            }
        }
    }



}
