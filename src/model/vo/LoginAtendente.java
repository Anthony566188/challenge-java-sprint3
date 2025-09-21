package model.vo;

public class LoginAtendente {
    private Atendente atendente;
    private String login;
    private String senha;

    public LoginAtendente(Atendente atendente, String login, String senha) {
        this.atendente = atendente;
        this.login = login;
        this.senha = senha;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
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
