package controller;

import model.dao.AtendenteDAO;
import model.vo.Atendente;

import java.util.List;

public class AtendenteController {

    private AtendenteDAO atendenteDAO;

    public AtendenteController(){
        atendenteDAO = new AtendenteDAO();
    }

    public void inserir(Atendente atendente){
        atendenteDAO.inserirAtendente(atendente);
    }

    public List<Atendente> listar(){
        return atendenteDAO.listarAtendentes();
    }
}
