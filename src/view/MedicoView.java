package view;

import controller.EspecialidadeController;
import controller.MedicoController;
import model.vo.Atendente;
import model.vo.Especialidade;
import model.vo.Medico;
import model.vo.Paciente;

import java.util.List;

public class MedicoView {

    private MedicoController controller;
    private EspecialidadeController especialidadeController;

    public MedicoView(){
        controller = new MedicoController();
        especialidadeController = new EspecialidadeController();
    }

    public void inserirMedico(){
        List<Especialidade> especialidades = especialidadeController.listar();

        Especialidade especialidadeSelecionada = especialidades.get(0);

        controller.inserir(new Medico(especialidadeSelecionada, "Fernando"));
    }

    public void listarMedicos(){
        System.out.println("Listando Médicos...");
        for (Medico medico : controller.listar()) {
            System.out.println("------------------------------------------");
            System.out.println("ID: " + medico.getId());
            System.out.println("ID da Especialidade: " + medico.getEspecialidade().getId());
            System.out.println("Nome: " + medico.getNome());
        }
    }
}
