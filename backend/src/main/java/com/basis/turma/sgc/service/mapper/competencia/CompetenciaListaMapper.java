package com.basis.turma.sgc.service.mapper.competencia;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaDTO;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaListaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaListaMapper extends EntidadeMapper<Competencia, CompetenciaListaDTO> {

//    @Override
//    @Mapping(source = "categoriaDescricao", target = "categoria.descricao")
//    Competencia paraEntidade(CompetenciaListaDTO dto);
//
//    @Override
//    @InheritInverseConfiguration
//    CompetenciaListaDTO paraDTO(Competencia entidade);

}
