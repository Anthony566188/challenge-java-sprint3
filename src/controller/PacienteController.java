package controller;

import model.dao.PacienteDAO;
import model.vo.Paciente;

import java.util.List;

public class PacienteController {

    private PacienteDAO pacienteDAO;

    public PacienteController() {
        pacienteDAO = new PacienteDAO();
    }

    public void inserir(Paciente paciente) {
        pacienteDAO.inserirPaciente(paciente);
    }

    public List<Paciente> listar(){
        return pacienteDAO.listarPacientes();
    }

    public void excluir(int id){
        pacienteDAO.excluirPaciente(id);
    }

}
