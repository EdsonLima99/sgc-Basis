package com.basis.turma.sgc.service.dto.colaborador;


import com.basis.turma.sgc.service.dto.colabcomp.ColaboradorCompetenciaListaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String email;

    private byte[] foto;

    private LocalDate dataNascimento;

    private LocalDate dataAdmissao;

    private Integer senioridadeId;

    private List<ColaboradorCompetenciaListaDTO> colaboradorCompetencias;

}
