package view;

import controller.TipoProblemaController;
import model.vo.TipoProblema;

public class TipoProblemaView {

    private TipoProblemaController controller;

    public TipoProblemaView(){
        controller = new TipoProblemaController();
    }

    public void inserirTipoProblema(TipoProblema tipoProblema) {
        controller.inserir(tipoProblema);
    }

    public void listarTiposProblemas() {
        controller.listar();
    }
}
