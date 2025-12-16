package br.com.fiap.beans;

public class Medico {
    private int idMedico;
    private String nomeMedico;
    private String crm;
    private Especialidade especialidade;

    public Medico() {
    }

    public Medico(int idMedico, String nomeMedico, String crm, Especialidade especialidade) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}