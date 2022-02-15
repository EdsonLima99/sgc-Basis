package com.basis.turma.sgc.service.mapper.competencia;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetenciaListaMapper extends EntidadeMapper<Competencia, CompetenciaListaDTO> {
}
