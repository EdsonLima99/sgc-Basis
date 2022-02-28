package com.basis.turma.sgc.service.dto.colaborador;

import com.basis.turma.sgc.service.dto.colabcomp.ColaboradorCompetenciaListaDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotBlank(message = "Sobrenome obrigatório!")
    private String sobrenome;

    @NotBlank(message = "Cpf é obrigatório!")
    //@CPF(message = "Cpf em formato inválido!")
    private String cpf;

    @NotBlank(message = "Email é obrigatório!")
    //@Email(message = "Email em formato inválido!")
    private String email;

    private byte[] foto;

    @NotNull(message = "Data de nascimento é obrigatória!")
    @Past(message = "Data de nascimento deve ser uma data passada!" )
    private LocalDate dataNascimento;

    @NotNull(message = "Data de admissão é obrigatória!")
    private LocalDate dataAdmissao;

    @NotNull(message = "Senioridade é obrigatória!")
    private Integer senioridadeId;

    @NotNull(message = "Competências e suas senioridades são obrigatórias!")
    private List<ColaboradorCompetenciaListaDTO> colaboradorCompetencias;
}
