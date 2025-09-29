package model.vo;

public class Atendente extends Usuario {

    private String email;

    public Atendente(int id, String nome, String email) {
        super(id, nome);
        this.email = email;
    }



    public Atendente(String nome, String email) {
        super(nome);
        this.email = email;
    }

    public Atendente(int id){
        super(id);
    }


    public Atendente() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
