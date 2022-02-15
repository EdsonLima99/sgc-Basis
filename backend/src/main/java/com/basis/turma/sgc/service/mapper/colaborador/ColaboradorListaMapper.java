package com.basis.turma.sgc.service.mapper.colaborador;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import com.basis.turma.sgc.service.mapper.colabcomp.ColaborarCompetenciaMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ColaborarCompetenciaMapper.class)
public interface ColaboradorListaMapper extends EntidadeMapper<Colaborador, ColaboradorListaDTO> {
}
