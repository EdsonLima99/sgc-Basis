package com.basis.turma.sgc.service.dto.competencia;

import com.basis.turma.sgc.service.dto.SelecionaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompetenciaListaDTO implements Serializable {

    private Integer id;

    private String nome;

    private String descricao;

    private SelecionaDTO categoriaId;
}
