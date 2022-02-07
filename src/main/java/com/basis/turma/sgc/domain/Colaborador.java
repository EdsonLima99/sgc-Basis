package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "colaborador", schema = "public")
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

    @Column(name = "foto")
    private Image foto;

    @Column(name = "dt_nascimento")
    private Date dt_nascimento;

    @Column(name = "dt_admissao")
    private Date dt_admissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_senioridade")
    private Senioridade senioridade;
}
