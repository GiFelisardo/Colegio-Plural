package com.colegio.plural.services;

@Service
public class AlunosService{
    @Autowired
    private AlunosRepository repository;
    
public Alunos cadastrar(Alunos alunos) {
        // Verifica se já existe um alunos com esse nome
        if (alunosRepository.existsByNome(alunos.getNome())) {
            throw new RuntimeException("Aluno já cadastrado");
        }
        else
            return alunosRepository.cadastrar(alunos);
}

public boolean delete(Integer id) {
    Alunos alunos = alunosRepository.findById(id).get();
    if(alunos != null) {
        alunosRepository.deleteById(id);
        return true;
    }
    return false;
}

 public List<Alunos> listarAlunos(Integer id) {
        return alunosRepository.findById();
    }

public Alunos buscarAlunos(Integer id) {
        return alunosRepository.findById(id).get();
    }
}