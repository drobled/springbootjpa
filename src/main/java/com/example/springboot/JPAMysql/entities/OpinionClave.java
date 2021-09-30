package com.example.springboot.JPAMysql.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OpinionClave implements Serializable {

    @Column(name="usuarioId")
    private int usuarioId;

    @Column(name="cursoId")
    private int cursoId;

}
