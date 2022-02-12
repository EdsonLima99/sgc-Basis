package com.basis.turma.sgc.service.dto.colaborador;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.domain.ColaboradorCompetenciaPK;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaboradorPK;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
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

    private Date dataNascimento;

    private Date dataAdmissao;

    private Integer senioridadeId;

    private List<ColaboradorCompetencia> colaboradores;

    private List<TurmaFormacaoCompetenciaColaborador> turmaColaboradores;

}
