package controller;

import model.dao.TipoProblemaDAO;
import model.vo.TipoProblema;

import java.util.List;

public class TipoProblemaController {

    private TipoProblemaDAO tipoProblemaDAO;

    public TipoProblemaController() {
        tipoProblemaDAO = new TipoProblemaDAO();
    }

    public void inserir(TipoProblema tipoProblema) {
        tipoProblemaDAO.inserirTipoProblema(tipoProblema);
    }

    public List<TipoProblema> listar() {
        return tipoProblemaDAO.listarTiposProblemas();
    }
}
