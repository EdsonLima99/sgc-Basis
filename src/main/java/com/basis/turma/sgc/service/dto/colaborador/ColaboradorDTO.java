package com.basis.turma.sgc.service.dto.colaborador;

<<<<<<< HEAD
import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.domain.ColaboradorCompetenciaPK;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaboradorPK;
=======
import com.basis.turma.sgc.service.dto.colabcomp.ColaboradorCompetenciaDTO;
>>>>>>> 97b6bed0ef2e2eebbc600c6f5f1c7743f87cbf22
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.Date;
=======
import java.time.LocalDate;
>>>>>>> 97b6bed0ef2e2eebbc600c6f5f1c7743f87cbf22
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

    //    private List<ColaboradorCompetenciaDTO> colaboradores;

    private List<TurmaFormacaoCompetenciaColaborador> turmaColaboradores;



}
