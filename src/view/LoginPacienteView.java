package view;

import controller.LoginPacienteController;
import controller.PacienteController;
import model.vo.LoginPaciente;
import model.vo.Paciente;

import java.util.List;


public class LoginPacienteView {

    private LoginPacienteController controller;
    private PacienteController pacienteController;


    public LoginPacienteView(){
        controller = new LoginPacienteController();
        pacienteController = new PacienteController();

    }



    public void inserirLoginPaciente(){
        List<Paciente> pacientes = pacienteController.listar();

        Paciente pacienteSelecionado = pacientes.get(0);

        controller.inserir(new LoginPaciente( "login123", "senha123", pacienteSelecionado));
    }
}
