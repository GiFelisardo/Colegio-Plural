package com.colegio.plural.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="responsaveis")
public class Responsaveis {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false)
    private String CPF;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Numero", nullable = false)
    private String numero;

    public Responsaveis() {
    }

    public Responsaveis(String CPF, String email, Integer id, String nome, String numero) {
        this.CPF = CPF;
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


}
