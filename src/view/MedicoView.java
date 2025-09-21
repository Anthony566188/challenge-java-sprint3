package view;

import controller.EspecialidadeController;
import controller.MedicoController;
import model.vo.Especialidade;
import model.vo.Medico;
import model.vo.Paciente;

import java.util.List;

public class MedicoView {

    private MedicoController medicoController;
    private EspecialidadeController especialidadeController;

    public MedicoView(){
        medicoController = new MedicoController();
        especialidadeController = new EspecialidadeController();
    }

    public void inserirMedico(){
        List<Especialidade> especialidades = especialidadeController.listar();

        Especialidade especialidadeSelecionada = especialidades.get(0);

        medicoController.inserirMedico(new Medico(especialidadeSelecionada, "Marcelo"));
    }
}
