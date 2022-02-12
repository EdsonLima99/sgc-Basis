package com.basis.turma.sgc.service.mapper.colaborador;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.service.dto.colabcomp.ColaboradorCompetenciaDTO;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper extends EntidadeMapper<Colaborador, ColaboradorDTO> {

    @Override
    @Mapping(source = "senioridadeId", target = "senioridade.id")
    Colaborador paraEntidade(ColaboradorDTO dto);

    @Override
    @InheritInverseConfiguration
    ColaboradorDTO paraDTO(Colaborador entidade);

//    @Mapping(source = "colaboradorId", target = "colaborador.id")
//    @Mapping(source = "competenciaId", target = "competencia.id")
//    @Mapping(source = "senioridade", target = "senioridade")
//    ColaboradorCompetencia paraEntidade(ColaboradorCompetenciaDTO dto);
}
