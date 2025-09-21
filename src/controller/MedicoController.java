package controller;

import model.dao.MedicoDAO;
import model.vo.Medico;

public class MedicoController {

    private MedicoDAO medicoDAO;

    public MedicoController() {
        medicoDAO = new MedicoDAO();
    }

    public void inserirMedico(Medico medico){
        medicoDAO.inserirMedico(medico);
    }
}
