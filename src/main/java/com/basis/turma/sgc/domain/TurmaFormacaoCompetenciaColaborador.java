package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turma_formacao_competencia_colaborador", schema = "public")
@Getter
@Setter
public class TurmaFormacaoCompetenciaColaborador implements Serializable {

        @EmbeddedId
        Formacao id;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("id_colaborador")
        @JoinColumn(name = "id_colaborador")
        private Colaborador colaborador;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("id_competencia")
        @JoinColumn(name = "id_competencia")
        private Competencia competencia;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("id_turma_formacao")
        @JoinColumn(name = "id_turma_formacao")
        private TurmaFormacao turmaFormacao;
}
