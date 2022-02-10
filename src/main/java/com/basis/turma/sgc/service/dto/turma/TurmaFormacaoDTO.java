package com.basis.turma.sgc.service.dto.turma;

import com.basis.turma.sgc.service.dto.colaboradorCompetencia.ColaboradorCompetenciaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TurmaFormacaoDTO implements Serializable {

    private Integer id;

    private String nome;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataTermino;

    private Integer statusId;

    List<ColaboradorCompetenciaDTO> colaboradores;

}
