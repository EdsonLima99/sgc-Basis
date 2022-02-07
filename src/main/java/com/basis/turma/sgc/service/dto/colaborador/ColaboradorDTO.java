package com.basis.turma.sgc.service.dto.colaborador;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String email;

    private Image foto;

    private Date dt_nascimento;

    private Date dt_admissao;

    private Integer senioridadeId;

}
