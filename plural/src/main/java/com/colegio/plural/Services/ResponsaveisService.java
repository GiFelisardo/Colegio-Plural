package com.colegio.plural.services;

public Responsaveis cadastrar(Responsaveis responsaveis) {
        // Verifica se já existe um responsaveis com esse nome
        if (responsaveisRepository.existsByNome(responsaveis.getNome())) {
            throw new RuntimeException("Responsavel já cadastrado");
        }
        else
            return responsaveisRepository.cadastrar(responsaveis);
}

public boolean delete(Integer id) {
    Responsaveis responsaveis = responsaveisRepository.findById(id).get();
    if(responsaveis != null) {
        responsaveisRepository.deleteById(id);
        return true;
    }
    return false;
}

 public List<Responsaveis> listarResponsaveis(Integer id) {
        return responsaveisRepository.findById();
    }

public Responsaveis buscarResponsaveis(Integer id) {
        return responsaveisRepository.findById(id).get();
    }