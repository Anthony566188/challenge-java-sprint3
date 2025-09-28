package controller;

import model.dao.ConversaDAO;
import model.vo.Conversa;

import java.util.List;

public class ConversaController {

    private ConversaDAO conversaDAO;

    public ConversaController(){
        conversaDAO = new ConversaDAO();
    }

    public void inserir(Conversa conversa){
        conversaDAO.inserirConversa(conversa);
    }

    public List<Conversa> listar(){
        return conversaDAO.listarConversas();
    }

    public void atualizarStatusTicket(Conversa conversa){
        conversaDAO.atualizarStatusTicket(conversa);
    }

    public void excluir(int id){
        conversaDAO.excluirCoversa(id);
    }

    public void pacienteAtualizarTicket(Conversa conversa){
        conversaDAO.pacienteAtualizarTicket(conversa);
    }

}
