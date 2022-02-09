package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ColaboradorCompetenciaSenioridade implements Serializable {

        @Column(name = "id_colaborador")
        private Integer id_colaborador;

        @Column(name = "id_competencia")
        private Integer id_competencia;

}
