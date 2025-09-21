package model.vo;

public class LoginPaciente {
    private Paciente paciente;
    private String login;
    private String senha;

    public LoginPaciente(Paciente paciente, String login, String senha) {
        this.paciente = paciente;
        this.login = login;
        this.senha = senha;
    }

    public LoginPaciente(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
