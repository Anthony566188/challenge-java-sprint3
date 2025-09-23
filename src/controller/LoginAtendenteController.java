package controller;

import model.dao.LoginAtendenteDAO;
import model.vo.Atendente;
import model.vo.LoginAtendente;

public class LoginAtendenteController {

    private LoginAtendenteDAO loginAtendenteDAO;

    public LoginAtendenteController(){
        loginAtendenteDAO = new LoginAtendenteDAO();
    }

    public void inserir(LoginAtendente loginAtendente){
        loginAtendenteDAO.inserirLoginAtendente(loginAtendente);
    }

    public Atendente autenticar(){
        return loginAtendenteDAO.autenticarAtendente();
    }
}
