package com.basis.turma.sgc.service.dto.colaborador;

import com.basis.turma.sgc.service.dto.SelecionaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ColaboradorListaDTO implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

    private String email;

    private Date datanascimento;

    private Date dataadmissao;

    private SelecionaDTO senioridade;

}
