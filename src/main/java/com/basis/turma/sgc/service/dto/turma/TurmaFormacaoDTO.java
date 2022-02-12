package com.basis.turma.sgc.service.dto.turma;

import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
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

//    @NotNull(message = "")
//    private List<ColaboradorDTO> colaboradores;

    private List<ColaboradorDTO> turmaColaboradores;

}
