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

        @ManyToOne
        @MapsId("id_colaborador")
        @JoinColumn(name = "id_colaborador")
        private Colaborador colaborador;

        @ManyToOne
        @MapsId("id_competencia")
        @JoinColumn(name = "id_competencia")
        private Competencia competencia;

        @Column(name = "senioridade")
        private Integer senioridade;

}
