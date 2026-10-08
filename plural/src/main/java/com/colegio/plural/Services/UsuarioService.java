package com.colegio.plural.serices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.colegio.plural.models.Usuario;
import com.colegio.plural.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public Usuario cadastrar(Usuario usuario) {

        if (repository.existsByNome(usuario.getNome())) {
            throw new RuntimeException("Usuário já cadastrado");
        }

        usuario.setSenha(
                passwordEncoder.encode(usuario.getSenha())
        );

        return repository.save(usuario);
    }

    public boolean delete(Integer id) {

        Usuario usuario = repository.findById(id).orElse(null);

        if (usuario != null) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Usuario> listarUsuario() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Usuario buscarUsuario(Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));
    }

    public Usuario login(String nome, String senha) {

        Usuario usuario = repository.findByNome(nome)
                .orElseThrow(() ->
                        new RuntimeException("Nome ou senha inválidos"));

        if (!passwordEncoder.matches(
                senha,
                usuario.getSenha())) {

            throw new RuntimeException(
                    "Nome ou senha inválidos");
        }

        return usuario;
    }
}