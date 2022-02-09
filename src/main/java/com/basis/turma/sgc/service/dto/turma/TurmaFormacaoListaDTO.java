package com.basis.turma.sgc.service.dto.turma;

import com.basis.turma.sgc.service.dto.SelecionaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class TurmaFormacaoListaDTO implements Serializable {

    private Integer id;

    private String nome;

    private Date dt_inicio;

    private Date dt_termino;

    private Integer colaboradorId;

    private SelecionaDTO status;
}
