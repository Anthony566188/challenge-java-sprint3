package view;

import controller.MedicoController;
import controller.MedicoLoginController;
import model.vo.Atendente;
import model.vo.Medico;
import model.vo.MedicoLogin;

import java.util.List;

public class MedicoLoginView {

    private MedicoLoginController controller;
    private MedicoController medicoController;

    public MedicoLoginView(){
        controller = new MedicoLoginController();
        medicoController = new MedicoController();
    }

    public void inserirMedicoLogin(){
        List<Medico> medicos = medicoController.listar();

        Medico medicoSelecionado = medicos.get(1);

        controller.inserir(new MedicoLogin( "loginFernado", "senhaFernando", medicoSelecionado));
    }

    public void excluirMedicoLogin(int id){
        controller.excluir(id);
    }

    public void autenticarMedico(){
        controller.autenticar();
    }

}
