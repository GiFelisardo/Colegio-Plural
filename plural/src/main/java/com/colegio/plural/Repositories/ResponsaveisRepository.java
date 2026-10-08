package com.colegio.plural.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.colegio.plural.models.Responsaveis;


@Repository
public interface ResponsaveisRepository 
        extends JpaRepository<Responsaveis, Integer> {

@Query("""
    SELECT r, a
    FROM Alunos a
    JOIN a.responsaveis r
    WHERE LOWER(r.nome) LIKE LOWER(CONCAT('%', :filtro, '%'))
       OR r.cpf LIKE CONCAT('%', :filtro, '%')
       OR LOWER(r.email) LIKE LOWER(CONCAT('%', :filtro, '%'))
       OR r.numero LIKE CONCAT('%', :filtro, '%')
       OR LOWER(a.nome) LIKE LOWER(CONCAT('%', :filtro, '%'))
""")
List<Object[]> pesquisar(@Param("filtro") String filtro);

}