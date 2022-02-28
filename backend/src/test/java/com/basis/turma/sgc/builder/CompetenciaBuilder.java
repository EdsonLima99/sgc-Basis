package com.basis.turma.sgc.builder;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.repository.CompetenciaRepository;
import com.basis.turma.sgc.service.CompetenciaService;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaListaMapper;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Collection;

public class CompetenciaBuilder extends ConstrutorDeEntidade<Competencia> {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private CompetenciaService competenciaService;

    @Autowired
    private CompetenciaMapper competenciaMapper;

    @Autowired
    private CompetenciaListaMapper competenciaListaMapper;

    @Override
    protected Competencia construirEntidade() throws ParseException {
        Competencia competencia = new Competencia();
        competencia.setNome("Git");
        competencia.setDescricao("Versionamento de código");

        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setDescricao("Backend");
        competencia.setCategoria(categoria);
        return null;
    }

    @Override
    protected Competencia persistir(Competencia entidade) {
        return competenciaRepository.save(entidade);
    }

    @Override
    protected Collection<Competencia> obterTodos() {
        return competenciaRepository.findAll();
    }

    @Override
    protected Competencia obterPorId(Long id){
        return competenciaListaMapper.paraEntidade(competenciaService.buscar(id.intValue()));
    }
}
