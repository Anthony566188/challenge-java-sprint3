package view;

import controller.EspecialidadeController;
import model.vo.Especialidade;

public class EspecialidadeView {

    private EspecialidadeController controller;

    public EspecialidadeView() {
        controller = new EspecialidadeController();
    }

    public void inserirEspecialidade(Especialidade especialidade) {
        controller.inserir(especialidade);
    }

    public void listarEspecialidades(){
        System.out.println("Listando Especialidades...");
        for (Especialidade especialidade : controller.listar()) {
            System.out.println("-------------------------------------------");
            System.out.println("ID: " + especialidade.getId());
            System.out.println("Nome: " + especialidade.getNome());
        }
    }

    public void atualizarEspecialidade(Especialidade especialidade) {
        controller.atualizar(especialidade);
    }

    public void excluirEspecialidade(int id) {
        controller.excluir(id);
    }
}
