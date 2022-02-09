package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class Formacao implements Serializable {

        @Column(name = "id_turma_formacao")
        private Integer id_turma_formacao;

        @Column(name = "id_colaborador")
        private Integer id_colaborador;

        @Column(name = "id_competencia")
        private Integer id_competencia;

}
