package com.colegio.plural.dto;

public class LoginResponseDTO {
    private Integer id;
    private String nome;

    public LoginResponseDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
