package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "descricao", nullable = false, length = 16)
    private String descricao;

}