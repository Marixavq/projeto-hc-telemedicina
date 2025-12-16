package br.com.fiap.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private int idConsulta;
    private Medico medico;
    private LocalDate data;
    private LocalTime horario;
    private String status;

    public Consulta() {
    }

    public Consulta(int idConsulta, Medico medico, LocalDate data, LocalTime horario, String status) {
        this.idConsulta = idConsulta;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}