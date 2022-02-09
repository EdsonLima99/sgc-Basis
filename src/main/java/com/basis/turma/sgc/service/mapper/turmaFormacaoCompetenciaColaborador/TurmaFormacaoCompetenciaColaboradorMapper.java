package com.basis.turma.sgc.service.mapper.turmaFormacaoCompetenciaColaborador;

import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.service.dto.turmaFormacaoCompetenciaColaborador.TurmaFormacaoCompetenciaColaboradorDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoCompetenciaColaboradorMapper extends EntidadeMapper<TurmaFormacaoCompetenciaColaborador, TurmaFormacaoCompetenciaColaboradorDTO> {

    @Override
    @Mapping(source = "id_turma_formacao", target = "turmaFormacao.id")
    @Mapping(source = "id_colaborador", target = "colaborador.id")
    @Mapping(source = "id_competencia", target = "competencia.id")
    TurmaFormacaoCompetenciaColaborador paraEntidade(TurmaFormacaoCompetenciaColaboradorDTO dto);

    @Override
    @InheritInverseConfiguration
    TurmaFormacaoCompetenciaColaboradorDTO paraDTO(TurmaFormacaoCompetenciaColaborador entidade);
}
