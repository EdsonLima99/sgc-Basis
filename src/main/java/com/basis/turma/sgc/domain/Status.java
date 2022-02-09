package com.basis.turma.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "status", schema = "public")
@Getter
@Setter
public class Status implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

}
