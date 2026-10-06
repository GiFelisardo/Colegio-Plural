package com.colegio.plural.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="alunos")
public class Alunos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Turma", nullable = false)
    private String turma;

    @Column(name = "TipoInclusão", nullable = false)
    private String tipo_inclusão;

    @ManyToMany
    @JoinTable(
        name = "responsaveis_alunos",
        joinColumns = @JoinColumn(name = "Alunos_id", referencedColumnName = "Id"),
        inverseJoinColumns = @JoinColumn(name = "Responsaveis_id", referencedColumnName = "Id")
    )
    private Set<Responsaveis> responsaveis;

    public Alunos() {
    }

    public Alunos(Integer id, String nome, Set<Responsaveis> responsaveis, String tipo_inclusão, String turma) {
        this.id = id;
        this.nome = nome;
        this.responsaveis = responsaveis;
        this.tipo_inclusão = tipo_inclusão;
        this.turma = turma;
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getTipo_inclusão() {
        return tipo_inclusão;
    }

    public void setTipo_inclusão(String tipo_inclusão) {
        this.tipo_inclusão = tipo_inclusão;
    }

    public Set<Responsaveis> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(Set<Responsaveis> responsaveis) {
        this.responsaveis = responsaveis;
    }


}