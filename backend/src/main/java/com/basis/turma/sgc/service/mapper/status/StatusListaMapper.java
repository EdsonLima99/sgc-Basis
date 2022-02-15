package com.basis.turma.sgc.service.mapper.status;


import com.basis.turma.sgc.domain.Status;
import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatusListaMapper extends EntidadeMapper<Status, SelecionaDTO> {

}
