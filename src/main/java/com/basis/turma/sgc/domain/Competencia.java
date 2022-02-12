package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;


@Entity
@Table(name = "competencia")
@Getter
@Setter
public class Competencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_competencia")
    @SequenceGenerator(name = "seq_competencia", allocationSize = 1, sequenceName = "seq_competencia")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;

//    @OneToMany(mappedBy = "competencia")
//    private List<TurmaFormacaoCompetenciaColaborador> turmaCompetencias;

}
