package com.colegio.plural.controllers;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")

public class UsuariosController {
    private final UsuariosRepository repository;
    public UsuariosController(UsuariosRepository repository) {
        this.repository = repository;
    }

    // CADASTRAR
    @PostMapping
    public Usuarios cadastrar(@RequestBody Usuarios usuarios) {
        return repository.save(usuarios);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Usuarios buscar(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado"));
    }

    // EDITAR
    @PutMapping("/{id}")
    public Usuarios editar(
            @PathVariable Integer id,
            @RequestBody Usuarios dados) {

        Usuarios usuarios = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado"));

        usuarios.setPsicologo_id(dados.getPsicologo_id());
        usuarios.setDataHora(dados.getDataHora());
        usuarios.setSala(dados.getSala());

        return repository.save(usuarios);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {

        repository.deleteById(id);
    }

    // LISTAR
    @GetMapping
    public List<Usuarios> listar() {
        return repository.findById();
    }

}
