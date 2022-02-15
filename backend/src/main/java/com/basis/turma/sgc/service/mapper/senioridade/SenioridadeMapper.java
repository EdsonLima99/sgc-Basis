package com.basis.turma.sgc.service.mapper.senioridade;

import com.basis.turma.sgc.domain.Senioridade;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SenioridadeMapper extends EntidadeMapper<Senioridade, SelecionaDTO> {

    @Override
    @Mapping(source = "id", target = "id")
    Senioridade paraEntidade(SelecionaDTO dto);

    @Override
    @InheritInverseConfiguration
    SelecionaDTO paraDTO(Senioridade entidade);
}
