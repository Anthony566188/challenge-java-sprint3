package model.vo;

import java.time.LocalDateTime;

public class Consulta {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataEHoraInicio; // TIPO DOS ATRIBUTOS DATA E HORA MUDADO POR INCOMPATIBILIDADE COM O BANCO DE DADOS
    private LocalDateTime dataEHoraFim;

    public Consulta(int id, Paciente paciente, Medico medico, LocalDateTime dataEHoraInicio, LocalDateTime dataEHoraFim) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataEHoraInicio = dataEHoraInicio;
        this.dataEHoraFim = dataEHoraFim;
    }

    // sem id
    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataEHoraInicio, LocalDateTime dataEHoraFim) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataEHoraInicio = dataEHoraInicio;
        this.dataEHoraFim = dataEHoraFim;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataEHoraInicio() {
        return dataEHoraInicio;
    }

    public void setDataEHoraInicio(LocalDateTime dataEHoraInicio) {
        this.dataEHoraInicio = dataEHoraInicio;
    }

    public LocalDateTime getDataEHoraFim() {
        return dataEHoraFim;
    }

    public void setDataEHoraFim(LocalDateTime dataEHoraFim) {
        this.dataEHoraFim = dataEHoraFim;
    }
}
