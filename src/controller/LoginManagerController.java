package controller;

import model.dao.ConsultaDAO;
import model.dao.LoginAtendenteDAO;
import model.dao.LoginPacienteDAO;
import model.dao.MedicoLoginDAO;
import model.vo.Consulta;
import model.vo.Paciente;

import java.util.List;
import java.util.Scanner;

public class LoginManagerController {

    private MedicoLoginDAO medicoLoginDAO;
    private LoginPacienteDAO loginPacienteDAO;
    private LoginAtendenteDAO loginAtendenteDAO;
    private PacienteController pacienteController;
    private ConsultaDAO consultaDAO;

    public LoginManagerController() {
        medicoLoginDAO = new MedicoLoginDAO();
        loginPacienteDAO = new LoginPacienteDAO();
        loginAtendenteDAO = new LoginAtendenteDAO();
        pacienteController = new PacienteController();
        consultaDAO = new ConsultaDAO();
    }

    public void autenticar() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("Selecione o tipo de usuário para autenticar:");
        System.out.println("1 - Médico");
        System.out.println("2 - Paciente");
        System.out.println("3 - Atendente");
        System.out.println("0 - Sair");
        System.out.print("Sua opção: ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                medicoLoginDAO.autenticarMedico();
                break;
            case 2:
                Paciente pacienteAutenticado = loginPacienteDAO.autenticarPaciente();
                if (pacienteAutenticado != null) {
                    List<Consulta> consultaAutenticado = consultaDAO.listarConsultas();

                    for (Consulta c : consultaAutenticado) {
                        if (c.getPaciente().getId() == pacienteAutenticado.getId()) {
                            // aqui você pode passar a consulta como parâmetro
                            pacienteController.exibirMenuPaciente(pacienteAutenticado, c);
                            // ou se quiser passar a consulta direto:
                            // pacienteController.exibirMenuConsulta(c);
                        }
                    }
                }
                break;

            case 3:
                loginAtendenteDAO.autenticarAtendente();
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
        sc.close();
    }
}
