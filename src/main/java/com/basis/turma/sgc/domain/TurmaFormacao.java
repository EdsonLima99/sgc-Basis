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
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "dt_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "dt_termino", nullable = false)
    private LocalDate dataTermino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;

    @OneToMany(mappedBy = "turmaFormacao", fetch = FetchType.LAZY)
    private List<TurmaFormacaoCompetenciaColaborador> turmaFormacaoCompetenciasColaboradores;
}
