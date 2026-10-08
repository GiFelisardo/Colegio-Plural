package com.colegio.plural.dto;

public class ResponsaveiscomAlunosDTO {
    private String cpf;
    private String email;
    private String numero;

    private List<AlunosResponsaveisDTO> alunos;

    public ResponsaveisComAlunosDTO(
            String nomeResponsavel,
            String cpf,
            String email,
            String numero,
            List<AlunosResponsaveisDTO> alunos) {

        this.nomeResponsavel = nomeResponsavel;
        this.cpf = cpf;
        this.email = email;
        this.numero = numero;
        this.alunos = alunos;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNumero() {
        return numero;
    }

    public List<AlunosResponsaveisDTO> getAlunos() {
        return alunos;
    }
}
