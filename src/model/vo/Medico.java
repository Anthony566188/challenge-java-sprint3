package model.vo;

public class Medico extends Usuario {

    private Especialidade especialidade;

    public Medico(int id, Especialidade especialidade, String nome) {
        super(id, nome);
        this.especialidade = especialidade;
    }

    // Construtor sem id
    public Medico(Especialidade especialidade, String nome) {
        super(nome);
        this.especialidade = especialidade;
    }

    public Medico(int id, String nome) {
        super(id, nome);
    }

    // apenas o id
    public Medico(int id) {
        super(id);
    }

    public  Medico() {

    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
