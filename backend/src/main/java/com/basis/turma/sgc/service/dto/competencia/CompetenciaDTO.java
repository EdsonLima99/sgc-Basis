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

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória!")
    private String descricao;

    @NotNull(message = "Categoria é obrigatória!")
    private Integer categoriaId;
}
