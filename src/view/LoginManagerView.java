package view;

import controller.*;
import model.vo.Atendente;
import model.vo.Consulta;
import model.vo.Paciente;

import java.util.List;
import java.util.Scanner;

public class LoginManagerView {

    private LoginPacienteController loginPacienteController;
    private ConsultaController consultaController;
    private LoginAtendenteController loginAtendenteController;
    private PacienteView pacienteView;
    private AtendenteView atendenteView;

    public LoginManagerView(){
        loginPacienteController = new LoginPacienteController();
        consultaController = new ConsultaController();
        loginAtendenteController = new LoginAtendenteController();
        pacienteView = new PacienteView();
        atendenteView = new AtendenteView();
    }

    public void autenticarUsuario() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Selecione o tipo de usuário para autenticar:");
            System.out.println("1 - Paciente");
            System.out.println("2 - Atendente");
            System.out.println("0 - Sair");
            System.out.print("Sua opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Paciente pacienteAutenticado = loginPacienteController.autenticar();
                    if (pacienteAutenticado != null) {
                        List<Consulta> consultaAutenticado = consultaController.listar();

                        for (Consulta c : consultaAutenticado) {
                            if (c.getPaciente().getId() == pacienteAutenticado.getId()) {
                                // aqui é passado o paciente autenticado e a consulta deste paciente como parâmetro
                                pacienteView.exibirMenuPaciente(pacienteAutenticado, c);
                            }
                        }
                    }
                    break;

                case 2:
                    Atendente atendenteAutenticado = loginAtendenteController.autenticar();
                    if (atendenteAutenticado != null) {
                        atendenteView.exibirMenuAtendente();
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }
}
