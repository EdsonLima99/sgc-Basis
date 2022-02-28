package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colaborador")
@Getter
@Setter
public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_colaborador")
    @SequenceGenerator(name = "seq_colaborador", allocationSize = 1, sequenceName = "seq_colaborador")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "cpf",  unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "dt_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_senioridade", referencedColumnName = "id", nullable = false)
    private Senioridade senioridade;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<ColaboradorCompetencia> colaboradorCompetencias;
}


