package com.basis.turma.sgc.service.dto.turma;

import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.dto.turmacompcolab.TurmaFormacaoCompetenciaColaboradorListaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class TurmaFormacaoListaDTO implements Serializable {

    private Integer id;

    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataTermino;

    private SelecionaDTO status;

    private List<TurmaFormacaoCompetenciaColaboradorListaDTO> turmaFormacaoCompetenciasColaboradores;

}
