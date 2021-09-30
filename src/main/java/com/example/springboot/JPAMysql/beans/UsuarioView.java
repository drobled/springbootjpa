package com.example.springboot.JPAMysql.beans;

import com.example.springboot.JPAMysql.entities.Curso;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioView {

    private String nombre;
    private String apellidos;
    private List<Curso> cursos;

}
