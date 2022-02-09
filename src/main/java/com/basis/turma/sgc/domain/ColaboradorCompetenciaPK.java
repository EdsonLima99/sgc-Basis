package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Table(name = "colaborador_competencia", schema = "public")
@Getter
@Setter
public class ColaboradorCompetenciaPK implements Serializable {

        private Integer idColaborador;

        private Integer idCompetencia;

}
