package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ColaboradorCompetenciaPK implements Serializable {

        private Integer colaboradorId;

        private Integer competenciaId;

}
