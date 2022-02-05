package com.basis.turma.sgc.service.dto.competencia;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompetenciaDTO implements Serializable {

    private Integer id;

    private String nome;

    private String descricao;

    private Integer categoriaId;
}
