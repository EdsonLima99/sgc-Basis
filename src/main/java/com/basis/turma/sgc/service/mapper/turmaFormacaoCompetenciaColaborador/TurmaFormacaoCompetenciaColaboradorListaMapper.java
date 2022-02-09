package com.basis.turma.sgc.service.mapper.turmaFormacaoCompetenciaColaborador;

import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.service.dto.turmaFormacaoCompetenciaColaborador.TurmaFormacaoCompetenciaColaboradorListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoCompetenciaColaboradorListaMapper extends EntidadeMapper<TurmaFormacaoCompetenciaColaborador, TurmaFormacaoCompetenciaColaboradorListaDTO> {
}
