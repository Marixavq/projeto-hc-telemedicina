package br.com.fiap.beans;

public class Especialidade {

    private int idEspecialidade;
    private String nomeEspecialidade;
    private String descricao;

    public Especialidade() {
    }

    public Especialidade(int idEspecialidade, String nomeEspecialidade, String descricao) {
        this.idEspecialidade = idEspecialidade;
        this.nomeEspecialidade = nomeEspecialidade;
        this.descricao = descricao;
    }

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}