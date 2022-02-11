package com.basis.turma.sgc.service.mapper.categoria;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.mapper.EntidadeMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends EntidadeMapper<Categoria, SelecionaDTO> {
}
