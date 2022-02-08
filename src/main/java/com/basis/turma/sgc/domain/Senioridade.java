package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "senioridade", schema = "public")
@Getter
@Setter
public class Senioridade implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "senioridade")
    private List<Colaborador> colaborador;
}