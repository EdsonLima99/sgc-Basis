package com.basis.turma.sgc.service.dto.turma;

import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.dto.colaboradorCompetencia.ColaboradorCompetenciaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TurmaFormacaoListaDTO implements Serializable {

    private Integer id;

    private String nome;

    private Date dataInicio;

    private Date dataTermino;

    private Integer colaboradorId;

    private SelecionaDTO status;

    List<ColaboradorCompetenciaDTO> colaboradores;
}
