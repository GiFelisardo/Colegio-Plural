package com.colegio.plural.serices;

import org.aspectj.apache.bcel.Repository;

import com.colegio.plural.models.Atendimentos;
import com.colegio.plural.repositories.AtendimentosRepository;

@Service
public class AtendimentosService{

    @Autowired
    private AtendimentosRepository repository;

    public Atendimentos cadastrar(Atendimentos atendimentos) {
            // Verifica se já existe um atendimentos com esse nome
            if (AtendimentosRepository.existsByNome(atendimentos.getNome())) {
                throw new RuntimeException("Atendimento já cadastrado");
            }
            else
                return AtendimentosRepository.cadastrar(atendimentos);
    }

    public Atendimentos editar(Integer id, Atendimentos dados) {

            Atendimentos atendimentos = Repository.findById(id)
                    .orElseThrow(() ->
                            new RuntimeException("Atendimento não encontrado"));

            atendimento.setTipo_atendimento(dados.getTipo_atendimento());
            atendimento.setResponsavel_atendimento(dados.getResponsavel_atendimento());
            atendimento.setDataAtendimento(dados.getDataAtendimento());
            atendimento.setAlunos(dados.getAlunos());

            return Repository.save(atendimentos);
        }

    public boolean delete(Integer id) {
        Atendimentos atendimentos = atendimentosRepository.findById(id).get();
        if(atendimentos != null) {
            atendimentosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Atendimentos> listarAtendimentosByDataAtendimento() {
            return AtendimentosRepository.findByDataAtendimento();
        }

    public Atendimentos buscarAtendimentos(Integer id) {
            return atendimentosRepository.findById(id).get();
        }
}