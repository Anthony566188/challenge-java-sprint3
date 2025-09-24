package model.vo;

public class LoginAtendente extends LoginManager{
    private Atendente atendente;

    public LoginAtendente(String login, String senha, Atendente atendente) {
        super(login, senha);
        this.atendente = atendente;
    }


    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }


}
