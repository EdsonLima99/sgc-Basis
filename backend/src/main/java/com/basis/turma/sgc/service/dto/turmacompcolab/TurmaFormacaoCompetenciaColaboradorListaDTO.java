package com.basis.turma.sgc.service.dto.turmacompcolab;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TurmaFormacaoCompetenciaColaboradorListaDTO implements Serializable {

    private Integer turmaFormacaoId;

    private Integer competenciaId;

    private Integer colaboradorId;
}
