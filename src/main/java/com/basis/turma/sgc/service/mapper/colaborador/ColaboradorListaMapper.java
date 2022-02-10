package com.basis.turma.sgc.service.mapper.colaborador;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColaboradorListaMapper extends EntidadeMapper<Colaborador, ColaboradorListaDTO> {
}
