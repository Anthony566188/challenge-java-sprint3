package controller;

import model.dao.MedicoLoginDAO;
import model.vo.MedicoLogin;

public class MedicoLoginController {

    private MedicoLoginDAO medicoLoginDAO;

    public MedicoLoginController() {
        medicoLoginDAO = new MedicoLoginDAO();
    }

    public void inserir(MedicoLogin medicoLogin) {
        medicoLoginDAO.inserirMedicoLogin(medicoLogin);
    }

    public void excluir(int id) {
        medicoLoginDAO.excluirMedicoLogin(id);
    }

    public void autenticar() {
       medicoLoginDAO.autenticarMedico();
    }
}
