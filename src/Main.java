import model.vo.Atendente;
import model.vo.Especialidade;
import model.vo.Medico;
import model.vo.Paciente;
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

        //pacienteView.inserirPaciente(new Paciente("123.456.789-00", "Anthony", "123456", "01/07/06", "Passagem1234"));

        //pacienteView.listarPaciente();


        //loginPacienteView.inserirLoginPaciente();

        //loginPacienteView.autenticarPaciente();




        //atendenteView.inserirAtendente(new Atendente("Romário", "romario123@gmail.com"));

        //atendenteView.listarAtendentes();


        //loginAtendenteView.inserirLoginAtendente();

        //loginAtendenteView.autenticarAtendente();




        //especialidadeView.inserirEspecialidade(new Especialidade("Cardiologista"));

        //especialidadeView.listarEspecialidades();




        //medicoView.inserirMedico();

    }
}