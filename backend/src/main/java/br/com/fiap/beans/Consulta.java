package br.com.fiap.beans;

import java.time.LocalDateTime;

public class Consulta {
    private int idConsulta;
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime dataHora;
    private String status;

    public Consulta() {
    }

    public Consulta(int idConsulta, Medico medico, Paciente paciente, LocalDateTime dataHora, String status) {
        this.idConsulta = idConsulta;
        this.medico = medico;
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.status = status;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}