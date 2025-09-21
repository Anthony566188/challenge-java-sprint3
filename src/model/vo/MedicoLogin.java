package model.vo;

public class MedicoLogin {

    private Medico medico;
    private String login;
    private String senha;

    public MedicoLogin(Medico medico, String login, String senha) {
        this.medico = medico;
        this.login = login;
        this.senha = senha;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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
