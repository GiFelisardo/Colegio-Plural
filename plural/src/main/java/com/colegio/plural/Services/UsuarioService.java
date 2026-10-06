package com.colegio.plural.serices;

public Usuario cadastrar(Usuario usuario) {
        // Verifica se já existe um usuario com esse nome
        if (usuarioRepository.existsByNome(usuario.getNome())) {
            throw new RuntimeException("Usuario já cadastrado");
        }
        else
            return usuarioRepository.cadastrar(usuario);
}

public boolean delete(Integer id) {
    Usuario usuario = usuarioRepository.findById(id).get();
    if(usuario != null) {
        usuarioRepository.deleteById(id);
        return true;
    }
    return false;
}

 public List<Usuario> listarUsuario(Integer id) {
        return usuarioRepository.findById();
    }

public Usuario buscarUsuario(Integer id) {
        return usuarioRepository.findById(id).get();
    }
