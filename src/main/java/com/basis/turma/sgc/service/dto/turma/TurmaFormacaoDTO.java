package com.basis.turma.sgc.service.dto.turma;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class TurmaFormacaoDTO implements Serializable {

    private Integer id;

    private String nome;

    private Date dt_inicio;

    private Date dt_termino;

    private Integer statusId;

    private Integer colaboradorId;

    private Integer competenciaId;


}
