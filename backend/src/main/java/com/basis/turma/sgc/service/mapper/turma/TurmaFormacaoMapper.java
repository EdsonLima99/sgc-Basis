package com.basis.turma.sgc.service.mapper.turma;

import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoMapper extends EntidadeMapper<TurmaFormacao, TurmaFormacaoDTO> {

    @Override
    @Mapping(source = "statusId", target = "status.id")
    @Mapping(target = "turmaFormacaoCompetenciasColaboradores", ignore = true)
    TurmaFormacao paraEntidade(TurmaFormacaoDTO dto);

    @Override
    @InheritInverseConfiguration
    @Mapping(target = "turmaFormacaoCompetenciasColaboradores", ignore = true)
    TurmaFormacaoDTO paraDTO(TurmaFormacao entidade);
}
