package com.basis.turma.sgc.service.mapper.colaborador;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper extends EntidadeMapper<Colaborador, ColaboradorDTO> {

    @Override
    @Mapping(source = "senioridadeId", target = "senioridade.id")
    @Mapping(target = "colaboradorCompetencias", ignore = true)
    Colaborador paraEntidade(ColaboradorDTO dto);

    @Override
    @InheritInverseConfiguration
    @Mapping(target = "colaboradorCompetencias", ignore = true)
    ColaboradorDTO paraDTO(Colaborador entidade);
}
