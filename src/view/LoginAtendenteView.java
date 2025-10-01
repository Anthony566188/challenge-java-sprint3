package view;

import controller.AtendenteController;
import controller.LoginAtendenteController;
import model.vo.Atendente;
import model.vo.LoginAtendente;

import java.util.List;

public class LoginAtendenteView {

    private LoginAtendenteController controller;
    private AtendenteController atendenteController;

    public LoginAtendenteView(){
        controller = new LoginAtendenteController();
        atendenteController = new AtendenteController();
    }

    public void inserirLoginAtendente(){
        List<Atendente> atendentes = atendenteController.listar();

        Atendente atendenteSelecionado = atendentes.get(2);

        controller.inserir(new LoginAtendente("loginPedro", "senhaPedro",  atendenteSelecionado));
    }

    public void atualizarLoginAtendente(){
        List<Atendente> atendentes = atendenteController.listar();

        Atendente atendenteSelecionado = atendentes.get(0);
        controller.Atualizar(new LoginAtendente("loginRomario", "senhaRomario",  atendenteSelecionado));
    }
}
