package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turma_formacao")
@Getter
@Setter
public class TurmaFormacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_turma_formacao")
    @SequenceGenerator(name = "seq_turma_formacao", allocationSize = 1, sequenceName = "seq_turma_formacao")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dt_inicio")
    private LocalDate dataInicio;

    @Column(name = "dt_termino")
    private LocalDate dataTermino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status")
    private Status status;

    @OneToMany(mappedBy = "turmaFormacao", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TurmaFormacaoCompetenciaColaborador> turmaFormacaoCompetenciasColaboradores;
}
