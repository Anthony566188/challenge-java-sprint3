package model.vo;

public class LoginPaciente extends LoginManager{
    private Paciente paciente;

    public LoginPaciente(String login, String senha, Paciente paciente) {
        super(login, senha);
        this.paciente = paciente;
    }

    public LoginPaciente(String login, String senha) {
        super(login, senha);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


}
