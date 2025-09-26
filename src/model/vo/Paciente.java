package model.vo;

public class Paciente extends  Usuario {
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String endereco;



    public Paciente(int id, String cpf, String nome, String rg, String dataNascimento, String endereco) {
        super(id, nome);
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    // Construtor sem id
    public Paciente(String cpf, String nome, String rg, String dataNascimento, String endereco) {
        super(nome);
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    // apenas o id
    public Paciente(int id){
        super(id);
    }

    public Paciente(){

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
