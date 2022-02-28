package com.basis.turma.sgc.service.dto.colaborador;

import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.dto.colabcomp.ColaboradorCompetenciaListaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ColaboradorListaDTO implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String email;

    private LocalDate dataNascimento;

    private LocalDate dataAdmissao;

    private SelecionaDTO senioridade;

    private List<ColaboradorCompetenciaListaDTO> colaboradorCompetencias;
}
