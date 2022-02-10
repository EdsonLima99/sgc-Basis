package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "colaborador_competencia", schema = "public")
@Getter
@Setter
public class ColaboradorCompetencia implements Serializable {

        @EmbeddedId
        ColaboradorCompetenciaPK id;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("idColaborador")
        @JoinColumn(name = "id_colaborador")
        private Colaborador colaborador;

        @ManyToOne(fetch = FetchType.LAZY)
        @MapsId("idCompetencia")
        @JoinColumn(name = "id_competencia")
        private Competencia competencia;

        @Column(name = "senioridade")
        private Integer senioridade;

}
