package controller;

import model.dao.MedicoDAO;
import model.vo.Medico;

import java.util.List;

public class MedicoController {

    private MedicoDAO medicoDAO;

    public MedicoController() {
        medicoDAO = new MedicoDAO();
    }

    public void inserir(Medico medico){
        medicoDAO.inserirMedico(medico);
    }

    public List<Medico> listar(){
        return medicoDAO.listarMedicos();
    }

    public void atualizar(Medico medico){
        medicoDAO.atualizarMedico(medico);
    }

    public void excluir(int id){
        medicoDAO.excluirMedico(id);
    }

}
