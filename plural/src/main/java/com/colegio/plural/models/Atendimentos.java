package com.colegio.plural.models;

import java.time.LocalDate;
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
@Table(name="atendimentos")
public class Atendimentos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "ResponsavelAtendimento", nullable = false)
    private String responsavel_atendimento;

    @Column(name = "TipoAtendimento", nullable = false)
    private String tipo_atendimento;

    @Column(name = "DataAtendimento", nullable = false)
    private LocalDate dataAtendimento;

    @ManyToMany
    @JoinTable(
        name = "responsaveis_alunos",
        joinColumns = @JoinColumn(name = "Atendimentos_id", referencedColumnName = "Id"),
        inverseJoinColumns = @JoinColumn(name = "Alunos_id", referencedColumnName = "Id")
    )
    private Set<Alunos> alunos;

    public Atendimentos() {
    }

    public Atendimentos(Set<Alunos> alunos, LocalDate dataAtendimento, Integer id, String responsavel_atendimento, String tipo_atendimento) {
        this.alunos = alunos;
        this.dataAtendimento = dataAtendimento;
        this.id = id;
        this.responsavel_atendimento = responsavel_atendimento;
        this.tipo_atendimento = tipo_atendimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponsavel_atendimento() {
        return responsavel_atendimento;
    }

    public void setResponsavel_atendimento(String responsavel_atendimento) {
        this.responsavel_atendimento = responsavel_atendimento;
    }

    public String getTipo_atendimento() {
        return tipo_atendimento;
    }

    public void setTipo_atendimento(String tipo_atendimento) {
        this.tipo_atendimento = tipo_atendimento;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Set<Alunos> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Alunos> alunos) {
        this.alunos = alunos;
    }

    


}