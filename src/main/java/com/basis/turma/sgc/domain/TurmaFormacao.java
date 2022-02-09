package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "turma_formacao", schema = "public")
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
    private Date dt_inicio;

    @Column(name = "dt_termino")
    private Date dt_termino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "turma_formacao_competencia_colaborador",
            joinColumns = { @JoinColumn(name = "id_turma_formacao") },
            inverseJoinColumns = { @JoinColumn(name = "id_competencia_turma_formacao") }
    )
    private List<Competencia> competenciasTurmaFormacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "turma_formacao_competencia_colaborador",
            joinColumns = { @JoinColumn(name = "id_turma_formacao") },
            inverseJoinColumns = { @JoinColumn(name = "id_colaborador_turma_formacao") }
    )
    private List<Colaborador> colaboradoresTurmaFormacao;









}
