package com.colegio.plural.services;

@Service
public class ResponsaveisService{

    @Autowired
    private ResponsaveisRepository repository;

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

    public List<ResponsaveisComAlunosDTO> pesquisar(String filtro) {

        List<Object[]> resultados = repository.pesquisar(filtro);

        Map<Integer, ResponsaveisComAlunosDTO> mapa = new LinkedHashMap<>();

        for (Object[] resultado : resultados) {

            Responsaveis responsavel = (Responsaveis) resultado[0];
            Alunos aluno = (Alunos) resultado[1];

            ResponsaveisComAlunosDTO dto = mapa.get(responsavel.getId());

            if (dto == null) {

                List<AlunosResponsaveisDTO> alunos = new ArrayList<>();

                alunos.add(
                    new AlunoResponsavelDTO(
                        aluno.getNome(),
                        aluno.getTurma(),
                        aluno.getTipoInclusao()
                    )
                );

                dto = new ResponsavelComAlunosDTO(
                    responsavel.getNome(),
                    responsavel.getCpf(),
                    responsavel.getEmail(),
                    responsavel.getNumero(),
                    alunos
                );

                mapa.put(responsavel.getId(), dto);

            } else {

                dto.getAlunos().add(
                    new AlunoResponsavelDTO(
                        aluno.getNome(),
                        aluno.getTurma(),
                        aluno.getTipoInclusao()
                    )
                );
            }
        }

        return new ArrayList<>(mapa.values());
    }
}