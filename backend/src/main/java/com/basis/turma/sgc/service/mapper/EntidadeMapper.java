package com.basis.turma.sgc.service.mapper;

import java.util.List;

public interface EntidadeMapper<Entidade, DTO> {

    Entidade paraEntidade(DTO dto);

    DTO paraDTO(Entidade entidade);

    List<DTO> listaParaDTOs(List<Entidade> entities);

    List<Entidade> listaParaEntidades(List<DTO> dtos);
}
