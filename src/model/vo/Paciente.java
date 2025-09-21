package model.vo;

public class Paciente {
    private int id;
    private String cpf; // UNIQUE
    private String nome;
    private String rg;
    private String dataNascimento;
    private String endereco;



    public Paciente(int id, String cpf, String nome, String rg, String dataNascimento, String endereco) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    // Construtor sem id
    public Paciente(String cpf, String nome, String rg, String dataNascimento, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
