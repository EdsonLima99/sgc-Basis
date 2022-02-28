package com.basis.turma.sgc.service.mapper.colabcomp;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.service.dto.colabcomp.ColaboradorCompetenciaListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaborarCompetenciaMapper extends EntidadeMapper<ColaboradorCompetencia, ColaboradorCompetenciaListaDTO> {

    @Override
    @Mapping(source = "colaboradorId", target = "id.colaboradorId")
    @Mapping(source = "competenciaId", target = "id.competenciaId")
    @Mapping(source = "colaboradorId", target = "colaborador.id")
    @Mapping(source = "competenciaId", target = "competencia.id")
    ColaboradorCompetencia paraEntidade(ColaboradorCompetenciaListaDTO dto);

    @Override
    @InheritInverseConfiguration
    ColaboradorCompetenciaListaDTO paraDTO(ColaboradorCompetencia entidade);

}
