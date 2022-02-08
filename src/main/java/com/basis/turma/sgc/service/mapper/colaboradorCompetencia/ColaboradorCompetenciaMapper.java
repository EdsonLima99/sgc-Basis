package com.basis.turma.sgc.service.mapper.colaboradorCompetencia;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.service.dto.colaboradorCompetencia.ColaboradorCompetenciaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColaboradorCompetenciaMapper extends EntidadeMapper<ColaboradorCompetencia, ColaboradorCompetenciaDTO> {

    @Override
    @Mapping(source = "senioridade", target = "senioridade")
    ColaboradorCompetencia paraEntidade(ColaboradorCompetenciaDTO dto);

    @Override
    @InheritInverseConfiguration
    ColaboradorCompetenciaDTO paraDTO(ColaboradorCompetencia entidade);
}
