package com.example.springboot.JPAMysql.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="opiniones")
@Getter
@Setter
public class Opinion {

    @EmbeddedId
    private OpinionClave id;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name="usuarioId")
    private Usuario  usuario;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name="cursoId")
    private Curso curso;

    private String mensaje;

}
