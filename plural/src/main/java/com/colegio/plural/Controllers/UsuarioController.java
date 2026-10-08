package com.colegio.plural.controllers;

import com.colegio.plural.dto.LoginDTO;
import com.colegio.plural.dto.LoginResponseDTO;
import com.colegio.plural.models.Usuario;
import com.colegio.plural.repositories.UsuarioRepository;
import com.colegio.plural.services.UsuarioService;

import jakarta.servlet.http.HttpSession;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository repository;
    private final UsuarioService service;

    public UsuarioController(
            UsuarioRepository repository,
            UsuarioService service) {

        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return service.cadastrar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));
    }

    @PutMapping("/{id}")
    public Usuario editar(
            @PathVariable Integer id,
            @RequestBody Usuario dados) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        usuario.setPsicologo_id(dados.getPsicologo_id());
        usuario.setDataHora(dados.getDataHora());
        usuario.setSala(dados.getSala());

        return repository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody LoginDTO dados,
            HttpSession session) {

        Usuario usuario = service.login(
                dados.getNome(),
                dados.getSenha()
        );

        session.setAttribute("usuarioLogado", usuario.getId());

        return new LoginResponseDTO(
                usuario.getId(),
                usuario.getNome()
        );
    }

    @GetMapping("/me")
    public LoginResponseDTO usuarioLogado(HttpSession session) {

        Integer id = (Integer) session.getAttribute("usuarioLogado");

        if (id == null) {
            throw new RuntimeException("Usuário não está logado");
        }

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        return new LoginResponseDTO(
                usuario.getId(),
                usuario.getNome()
        );
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "Logout realizado com sucesso";
    }
}
