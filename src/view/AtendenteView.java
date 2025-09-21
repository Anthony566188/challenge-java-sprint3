package view;

import controller.AtendenteController;
import model.vo.Atendente;
import model.vo.Paciente;

public class AtendenteView {

    private AtendenteController controller;

    public AtendenteView() {
        controller = new AtendenteController();
    }

    public void inserirAtendente(Atendente atendente){
        controller.inserir(atendente);
    }

    public void listarAtendentes(){
        System.out.println("Listando atendentes...");
        for (Atendente atendente : controller.listar()) {
            System.out.println("------------------------------------------");
            System.out.println("ID: " + atendente.getId());
            System.out.println("Nome: " + atendente.getNome());
            System.out.println("Email: " + atendente.getEmail());
        }

    }

}
