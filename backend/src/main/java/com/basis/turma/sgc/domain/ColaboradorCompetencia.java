package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "colaborador_competencia")
@Getter
@Setter
public class ColaboradorCompetencia implements Serializable {

        @EmbeddedId
        ColaboradorCompetenciaPK id;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("colaboradorId")
        @JoinColumn(name = "id_colaborador", nullable = false)
        private Colaborador colaborador;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("competenciaId")
        @JoinColumn(name = "id_competencia", nullable = false)
        private Competencia competencia;

        @Column(name = "senioridade", nullable = false)
        private Integer senioridade;

}
