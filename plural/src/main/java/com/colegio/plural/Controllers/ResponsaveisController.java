package com.colegio.plural.controllers;

@RestController
@RequestMapping("/responsaveis")
@CrossOrigin(origins = "*")

public class ResponsaveisController {
    private final ResponsaveisRepository repository;
    public ResponsaveisController(ResponsaveisRepository repository) {
        this.repository = repository;
    }

    // CADASTRAR
    @PostMapping
    public Responsaveis cadastrar(@RequestBody Responsaveis responsaveis) {
        return repository.save(responsaveis);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Responsaveis buscar(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Responsável não encontrado"));
    }

    // EDITAR
    @PutMapping("/{id}")
    public Responsaveis editar(
            @PathVariable Integer id,
            @RequestBody Responsaveis dados) {

        Responsaveis responsaveis = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Responsável não encontrado"));

        responsaveis.setPsicologo_id(dados.getPsicologo_id());
        responsaveis.setDataHora(dados.getDataHora());
        responsaveis.setSala(dados.getSala());

        return repository.save(responsaveis);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {

        repository.deleteById(id);
    }

    // LISTAR
    @GetMapping
    public List<Responsaveis> listar() {
        return repository.findById();
    }

    @GetMapping("/pesquisar")
    public List<ResponsavelComAlunosDTO> pesquisar(
            @RequestParam String filtro) {

        return service.pesquisar(filtro);
    }

}