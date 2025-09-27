package controller;

import model.dao.ConversaDAO;
import model.vo.Conversa;

public class ConversaController {

    private ConversaDAO conversaDAO;

    public ConversaController(){
        conversaDAO = new ConversaDAO();
    }

    public void inserir(Conversa conversa){
        conversaDAO.inserirConversa(conversa);
    }
}
