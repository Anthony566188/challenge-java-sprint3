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






        loginManagerView.autenticarUsuario();


    }
}