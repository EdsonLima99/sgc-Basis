package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntidadeMapper<Competencia, CompetenciaDTO> {

    @Override
    @Mapping(source = "categoriaId", target = "categoria.id")
    Competencia paraEntidade(CompetenciaDTO dto);

    @Override
    @InheritInverseConfiguration
    CompetenciaDTO paraDTO(Competencia entidade);
}
