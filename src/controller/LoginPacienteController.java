package controller;

import model.dao.LoginPacienteDAO;
import model.vo.LoginPaciente;
import model.vo.Paciente;

public class LoginPacienteController {

    private LoginPacienteDAO loginPacienteDAO;

    public LoginPacienteController(){
        loginPacienteDAO = new LoginPacienteDAO();
    }

    public void inserir(LoginPaciente loginPaciente) {
        loginPacienteDAO.inserirLoginPaciente(loginPaciente);
    }

    public void autenticar() {
        loginPacienteDAO.autenticarPaciente();
    }

}
