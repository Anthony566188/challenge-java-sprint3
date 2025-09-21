package controller;

import model.dao.ConsultaDAO;
import model.vo.Consulta;

import java.util.List;

public class ConsultaController {

    private ConsultaDAO consultaDAO;

    public ConsultaController() {
        consultaDAO = new ConsultaDAO();
    }

    public void inserir(Consulta consulta) {
        consultaDAO.inserirConsulta(consulta);
    }

    public List<Consulta> listar(){
        return consultaDAO.listarConsultas();
    }
}
