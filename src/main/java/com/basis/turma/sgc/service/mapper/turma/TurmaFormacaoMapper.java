package com.basis.turma.sgc.service.mapper.turma;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoMapper extends EntidadeMapper<TurmaFormacao, TurmaFormacaoDTO> {

    @Override
    @Mapping(source = "statusId", target = "status.id")
    TurmaFormacao paraEntidade(TurmaFormacaoDTO dto);

    @Override
    @Mapping(source = "status.id", target = "statusId")
    TurmaFormacaoDTO paraDTO(TurmaFormacao entidade);
}
