package controller;

import model.dao.EspecialidadeDAO;
import model.vo.Especialidade;

import java.util.List;

public class EspecialidadeController {

    private EspecialidadeDAO especialidadeDAO;

    public EspecialidadeController() {
        especialidadeDAO = new EspecialidadeDAO();
    }

    public void inserir(Especialidade especialidade) {
        especialidadeDAO.inserirEspecialidade(especialidade);
    }

    public List<Especialidade> listar() {
        return  especialidadeDAO.listarEspecialidades();
    }

    public void excluir(int id) {
        especialidadeDAO.excluirEspecialidade(id);
    }

}
