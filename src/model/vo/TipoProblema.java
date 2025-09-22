package model.vo;

public class TipoProblema {

    private int id;
    private String nome;

    public TipoProblema(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Construtor sem id
    public TipoProblema(String nome) {
        this.nome = nome;
    }

    // apenas com id
    public TipoProblema(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
