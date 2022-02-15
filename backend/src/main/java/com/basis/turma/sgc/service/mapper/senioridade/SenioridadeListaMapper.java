package com.basis.turma.sgc.service.mapper.senioridade;

import com.basis.turma.sgc.domain.Senioridade;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SenioridadeListaMapper extends EntidadeMapper<Senioridade, SelecionaDTO> {
}
