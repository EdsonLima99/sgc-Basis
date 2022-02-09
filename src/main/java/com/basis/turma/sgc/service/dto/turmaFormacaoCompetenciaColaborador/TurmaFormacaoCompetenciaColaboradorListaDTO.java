package com.basis.turma.sgc.service.dto.turmaFormacaoCompetenciaColaborador;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TurmaFormacaoCompetenciaColaboradorListaDTO implements Serializable {

    private Integer id_turma_formacao;

    private Integer id_colaborador;

    private Integer id_competencia;

}
