package com.basis.turma.sgc.service.dto.colabcomp;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class ColaboradorCompetenciaListaDTO implements Serializable {

    private Integer colaboradorId;

    private Integer competenciaId;

    private Integer senioridade;
}
