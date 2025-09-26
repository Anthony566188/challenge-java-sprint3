package model.vo;

public class MedicoLogin extends Login {

    private Medico medico;

    public MedicoLogin(String login, String senha,  Medico medico) {
        super(login, senha);
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }


}
