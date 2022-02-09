package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria", schema = "public")
@Getter
@Setter
public class Categoria implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

//    @OneToMany(mappedBy = "categoria")
//    private List<Competencia> competencia;
}