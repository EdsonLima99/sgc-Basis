package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Table (name = "turma_formacao_competencia_colaborador")
@Getter
@Setter
public class TurmaFormacaoCompetenciaColaboradorPK implements Serializable {

        private Integer turmaFormacaoId;

        private Integer colaboradorId;

        private Integer competenciaId;
}
