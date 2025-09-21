package model.vo;

public class Medico {

    private int id;
    private Especialidade especialidade;
    private String nome;

    public Medico(int id, Especialidade especialidade, String nome) {
        this.id = id;
        this.especialidade = especialidade;
        this.nome = nome;
    }

    // Construtor sem id
    public Medico(Especialidade especialidade, String nome) {
        this.especialidade = especialidade;
        this.nome = nome;
    }

    // apenas o id
    public Medico(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
