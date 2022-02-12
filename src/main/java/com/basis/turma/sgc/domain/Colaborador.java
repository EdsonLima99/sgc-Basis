package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "colaborador")
@Getter
@Setter
public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_colaborador")
    @SequenceGenerator(name = "seq_colaborador", allocationSize = 1, sequenceName = "seq_colaborador")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "dt_admissao")
    private LocalDate dataAdmissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_senioridade", referencedColumnName = "id")
    private Senioridade senioridade;

//    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<ColaboradorCompetencia> colaboradores;
}
