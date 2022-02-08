package com.basis.turma.sgc.service.dto.colaboradorCompetencia;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;;

@Getter
@Setter
public class ColaboradorCompetenciaDTO implements Serializable {

    private Integer id_colaborador;

    private Integer id_competencia;

    private Integer senioridade;

}
