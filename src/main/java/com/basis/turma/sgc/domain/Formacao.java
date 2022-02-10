package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Table (name = "turma_formacao_competencia_colaborador")
@Getter
@Setter
public class Formacao implements Serializable {

        private Integer idTurmaFormacao;

        private Integer idColaborador;

        private Integer idCompetencia;

}
