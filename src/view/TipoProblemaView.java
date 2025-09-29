package view;

import controller.TipoProblemaController;
import model.vo.Consulta;
import model.vo.Medico;
import model.vo.Ticket;
import model.vo.TipoProblema;

import java.util.List;
import java.util.Scanner;

public class TipoProblemaView {

    private TipoProblemaController controller;

    public TipoProblemaView(){
        controller = new TipoProblemaController();
    }

    public void inserirTipoProblema(TipoProblema tipoProblema) {
        controller.inserir(tipoProblema);
    }

    public void listarTiposProblemas() {
        System.out.println("Listando Tipos de Problemas...");
        for (TipoProblema tipoProblema : controller.listar()) {
            System.out.println("------------------------------------------");
            System.out.println("ID: " + tipoProblema.getId());
            System.out.println("Nome: " + tipoProblema.getNome());
        }
    }

    public void atualizarTipoProblema(TipoProblema tipoProblema) {
        controller.atualizar(tipoProblema);
    }

    public void excluirTipoProblema(int id) {
        controller.excluir(id);
    }

}
