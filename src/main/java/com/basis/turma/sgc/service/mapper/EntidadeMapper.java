package com.basis.turma.sgc.service.mapper;

public interface EntidadeMapper<Entidade, DTO> {

    Entidade paraEntidade(DTO dto);

    DTO paraDTO(Entidade entidade);
}
