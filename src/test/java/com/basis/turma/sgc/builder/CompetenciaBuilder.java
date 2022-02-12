package com.basis.turma.sgc.builder;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.repository.CompetenciaRepository;
import com.basis.turma.sgc.service.CompetenciaService;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaDTO;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaListaMapper;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class CompetenciaBuilder extends ConstrutorDeEntidade<CompetenciaDTO>{

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private CompetenciaService competenciaService;

    @Autowired
    private CompetenciaMapper competenciaMapper;

    @Autowired
    private CompetenciaListaMapper competenciaListaMapper;

    @Override
    public CompetenciaDTO construirEntidade() throws ParseException {
        CompetenciaDTO competenciaDTO = new CompetenciaDTO();
        competenciaDTO.setNome("Git");
        competenciaDTO.setDescricao("Versionamento de código");
        return competenciaDTO;

//        Categoria categoria = new Categoria();
//        categoria.setId(1);
//        categoria.setDescricao("Backend");
//        competencia.setCategoria(categoria);
//        return competencia;
    }

    @Override
    public CompetenciaDTO persistir(CompetenciaDTO entidade) {
        Competencia competencia = competenciaMapper.paraEntidade(entidade);
        return competenciaMapper.paraDTO(competenciaRepository.save(competencia));
    }

    @Override
    protected Collection<CompetenciaDTO> obterTodos() {
        return competenciaService.buscarTodas();
    }

    @Override
    protected CompetenciaDTO obterPorId(Long id) {
        return competenciaListaMapper.paraEntidade(competenciaService.buscar(id.intValue()));
    }


}
