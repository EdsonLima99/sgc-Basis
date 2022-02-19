package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class TurmaFormacaoCompetenciaColaboradorPK implements Serializable {

        private Integer turmaFormacaoId;

        private Integer colaboradorId;

        private Integer competenciaId;
}
