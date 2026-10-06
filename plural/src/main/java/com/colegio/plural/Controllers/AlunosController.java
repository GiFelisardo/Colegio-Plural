package com.colegio.plural.controllers;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")

public class AlunosController {
    private final AlunosRepository repository;
    public AlunosController(AlunosRepository repository) {
        this.repository = repository;
    }

    // CADASTRAR
    @PostMapping
    public Alunos cadastrar(@RequestBody Alunos alunos) {
        return repository.save(alunos);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Alunos buscar(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado"));
    }

    // EDITAR
    @PutMapping("/{id}")
    public Alunos editar(
            @PathVariable Integer id,
            @RequestBody Alunos dados) {

        Alunos alunos = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado"));

        alunos.setPsicologo_id(dados.getPsicologo_id());
        alunos.setDataHora(dados.getDataHora());
        alunos.setSala(dados.getSala());

        return repository.save(alunos);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {

        repository.deleteById(id);
    }

    // LISTAR
    @GetMapping
    public List<Alunos> listar() {
        return repository.findById();
    }

}