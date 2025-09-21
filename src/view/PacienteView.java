package view;

import controller.PacienteController;
import model.vo.Paciente;

public class PacienteView {
    private PacienteController controller;

    public PacienteView() {
        controller = new PacienteController();
    }

    public void inserirPaciente(Paciente paciente) {
        controller.inserir(paciente);
    }

    public void listarPaciente() {
        System.out.println("Listando Pacientes...");
        for (Paciente paciente : controller.listar()) {
            System.out.println("-----------------------------------------------------");
            System.out.println("ID: " + paciente.getId());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Rg: " + paciente.getRg());
            System.out.println("Data de nascimento: " + paciente.getDataNascimento());
            System.out.println("Endereço:  " + paciente.getEndereco());
        }
    }

    public void excluirPaciente(int id){
        controller.excluir(id);
    }

}
