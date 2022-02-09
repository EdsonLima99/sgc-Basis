package com.basis.turma.sgc.service.mapper.colaboradorCompetencia;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.service.dto.colaboradorCompetencia.ColaboradorCompetenciaListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColaboradorCompetenciaListaMapper extends EntidadeMapper<ColaboradorCompetencia, ColaboradorCompetenciaListaDTO> {
}
