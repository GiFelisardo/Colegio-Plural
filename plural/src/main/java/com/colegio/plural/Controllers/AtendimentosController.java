package com.colegio.plural.controllers;

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

        Atendimentos atendimentos = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Atendimento não encontrado"));

        atendimentos.setPsicologo_id(dados.getPsicologo_id());
        atendimentos.setDataHora(dados.getDataHora());
        atendimentos.setSala(dados.getSala());

        return repository.save(atendimentos);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {

        repository.deleteById(id);
    }

    // LISTAR
    @GetMapping
    public List<Atendimentos> listar() {
        return repository.findByData_atendimento();
    }

}