package com.basis.turma.sgc.service.mapper.turma;

import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TurmaFormacaoListaMapper extends EntidadeMapper<TurmaFormacao, TurmaFormacaoListaDTO> {
}

