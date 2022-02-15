package com.basis.turma.sgc.service.mapper.turmacompcolab;

import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.service.dto.turmacompcolab.TurmaFormacaoCompetenciaColaboradorListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoCompetenciaColaboradorMapper extends EntidadeMapper<TurmaFormacaoCompetenciaColaborador, TurmaFormacaoCompetenciaColaboradorListaDTO> {

    @Override
    @Mapping(source = "competenciaId", target = "id.competenciaId")
    @Mapping(source = "colaboradorId", target = "id.colaboradorId")
    @Mapping(source = "turmaFormacaoId", target = "id.turmaFormacaoId")
    @Mapping(source = "competenciaId", target = "competencia.id")
    @Mapping(source = "colaboradorId", target = "colaborador.id")
    @Mapping(source = "turmaFormacaoId", target = "turmaFormacao.id")
    TurmaFormacaoCompetenciaColaborador paraEntidade(TurmaFormacaoCompetenciaColaboradorListaDTO dto);

    @Override
    @InheritInverseConfiguration
    TurmaFormacaoCompetenciaColaboradorListaDTO paraDTO(TurmaFormacaoCompetenciaColaborador entidade);
}
