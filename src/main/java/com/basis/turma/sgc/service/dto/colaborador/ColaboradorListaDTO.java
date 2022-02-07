package com.basis.turma.sgc.service.dto.colaborador;

import com.basis.turma.sgc.service.dto.SelecionaDTO;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ColaboradorListaDTO implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String email;

    private BufferedImage foto;

    private Date dt_nascimento;

    private Date dt_admissao;

    private SelecionaDTO senioridade;

}
