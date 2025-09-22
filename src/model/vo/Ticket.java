package model.vo;

public class Ticket {

    private int id;
    private Paciente paciente;
    private TipoProblema tipoProblema;
    private Consulta consulta;

    public Ticket(int id, Paciente paciente, TipoProblema tipoProblema, Consulta consulta) {
        this.id = id;
        this.paciente = paciente;
        this.tipoProblema = tipoProblema;
        this.consulta = consulta;
    }

    // Construtor sem id
    public Ticket(Paciente paciente, TipoProblema tipoProblema, Consulta consulta) {
        this.paciente = paciente;
        this.tipoProblema = tipoProblema;
        this.consulta = consulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public TipoProblema getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(TipoProblema tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
