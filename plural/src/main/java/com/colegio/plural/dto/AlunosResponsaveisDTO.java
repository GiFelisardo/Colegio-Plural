package com.colegio.plural.dto;

public class AlunosResponsaveisDTO {
    private String Nome;
    private String Turma;
    private String TipoInclusão;

    public AlunosResponsaveisDTO(
            String nome,
            String turma,
            String tipoInclusao) {

        this.nome = nome;
        this.turma = turma;
        this.tipoInclusao = tipoInclusao;
    }

    public String getNome() {
        return nome;
    }

    public String getTurma() {
        return turma;
    }

    public String getTipoInclusao() {
        return tipoInclusao;
    }
}
