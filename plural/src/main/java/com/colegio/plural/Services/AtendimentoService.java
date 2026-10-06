package com.colegio.plural.serices;

public Atendimentos cadastrar(Atendimentos atendimentos) {
        // Verifica se já existe um atendimentos com esse nome
        if (atendimentosRepository.existsByNome(atendimentos.getNome())) {
            throw new RuntimeException("Atendimento já cadastrado");
        }
        else
            return atendimentosRepository.cadastrar(atendimentos);
}

public boolean delete(Integer id) {
    Atendimentos atendimentos = atendimentosRepository.findById(id).get();
    if(atendimentos != null) {
        atendimentosRepository.deleteById(id);
        return true;
    }
    return false;
}

 public List<Atendimentos> listarAtendimentosByDataHora() {
        return atendimentosRepository.findByDataHora();
    }

public Atendimentos buscarAtendimentos(Integer id) {
        return atendimentosRepository.findById(id).get();
    }
