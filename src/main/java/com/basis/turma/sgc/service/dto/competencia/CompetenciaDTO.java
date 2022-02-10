package com.basis.turma.sgc.service.dto.competencia;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CompetenciaDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    private String nome;

    @NotBlank(message = "A descrição não pode ser nula ou vazia")
    private String descricao;

    @NotNull(message = "A categoria não pode ser nula")
    private Integer categoriaId;
}
