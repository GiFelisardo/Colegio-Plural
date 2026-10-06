package com.colegio.plural.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.plural.models.Atendimentos;


@Repository
public interface AtendimentosRepository 
        extends JpaRepository<Atendimentos, Integer> {
}