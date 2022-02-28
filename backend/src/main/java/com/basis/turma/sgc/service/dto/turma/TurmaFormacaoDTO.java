package com.basis.turma.sgc.service.dto.turma;

import com.basis.turma.sgc.service.dto.turmacompcolab.TurmaFormacaoCompetenciaColaboradorListaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TurmaFormacaoDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória!")
    private String descricao;

    @NotNull(message = "Data de início é obrigatória!")
    private LocalDate dataInicio;

    @NotNull(message = "Data de término é obrigatória!")
    private LocalDate dataTermino;

    @NotNull(message = "Status é obrigatório!")
    private Integer statusId;

    private List<TurmaFormacaoCompetenciaColaboradorListaDTO> turmaFormacaoCompetenciasColaboradores;


}
