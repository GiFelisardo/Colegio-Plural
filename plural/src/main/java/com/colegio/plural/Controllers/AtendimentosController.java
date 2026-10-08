package com.colegio.plural.controllers;

import java.util.List;

import org.hibernate.service.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.plural.models.Atendimentos;
import com.colegio.plural.repositories.AtendimentosRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/atendimentos")
@CrossOrigin(origins = "*")

public class AtendimentosController {
    private final AtendimentosRepository repository;
    public AtendimentosController(AtendimentosRepository repository) {
        this.repository = repository;
    }

    // CADASTRAR
    @PostMapping
    public Atendimentos cadastrar(@RequestBody Atendimentos atendimentos) {
        return repository.save(atendimentos);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Atendimentos buscar(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Atendimento não encontrado"));
    }

    // EDITAR
    @PutMapping("/{id}")
public Atendimentos editar(
        @PathVariable Integer id,
        @RequestBody Atendimentos dados) {

    return Service.editar(id, dados);
}

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {

        repository.deleteById(id);
    }

    // LISTAR
    @GetMapping
    public List<Atendimentos> listar() {
        return repository.findByDataAtendimento();
    }

}