package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turma_formacao_competencia_colaborador")
@Getter
@Setter
public class TurmaFormacaoCompetenciaColaborador implements Serializable {

        @EmbeddedId
        TurmaFormacaoCompetenciaColaboradorPK id;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("colaboradorId")
        @JoinColumn(name = "id_colaborador", nullable = false)
        private Colaborador colaborador;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("competenciaId")
        @JoinColumn(name = "id_competencia", nullable = false)
        private Competencia competencia;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("turmaFormacaoId")
        @JoinColumn(name = "id_turma_formacao", nullable = false)
        private TurmaFormacao turmaFormacao;
}
