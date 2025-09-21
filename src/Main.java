import model.vo.*;
import view.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PacienteView pacienteView = new PacienteView();
        LoginPacienteView loginPacienteView = new LoginPacienteView();
        AtendenteView atendenteView = new AtendenteView();
        LoginAtendenteView loginAtendenteView = new LoginAtendenteView();
        EspecialidadeView especialidadeView = new EspecialidadeView();
        MedicoView medicoView = new MedicoView();
        MedicoLoginView medicoLoginView = new MedicoLoginView();
        LoginManagerView loginManagerView = new LoginManagerView();
        TipoProblemaView tipoProblemaView = new TipoProblemaView();
        ConsultaView consultaView = new ConsultaView();
        TicketView ticketView = new TicketView();

        //pacienteView.inserirPaciente(new Paciente("123.456.789-00", "Anthony", "123456", "01/07/06", "Passagem1234"));

        //pacienteView.listarPaciente();


        //loginPacienteView.inserirLoginPaciente();




        //atendenteView.inserirAtendente(new Atendente("Romário", "romario123@gmail.com"));

        //atendenteView.listarAtendentes();


        //loginAtendenteView.inserirLoginAtendente();




        //especialidadeView.inserirEspecialidade(new Especialidade("Cardiologista"));

        //especialidadeView.listarEspecialidades();




        //medicoView.inserirMedico();

        //medicoView.listarMedicos();


        //medicoLoginView.inserirMedicoLogin();




//        tipoProblemaView.inserirTipoProblema(new TipoProblema("Problema 1"));
//        tipoProblemaView.inserirTipoProblema(new TipoProblema("Problema 2"));
//        tipoProblemaView.inserirTipoProblema(new TipoProblema("Problema 3"));




        //consultaView.inserirConsulta();

        //consultaView.listarConsultas();




        //ticketView.criarTicket();





        loginManagerView.autenticarUsuario();

    }
}