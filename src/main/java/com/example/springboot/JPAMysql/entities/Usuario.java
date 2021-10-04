package com.example.springboot.JPAMysql.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Usuarios")
@Setter
@Getter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;
    private String clave;
    private String email;
    private String apellidos;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @ManyToMany
    @JoinTable(name = "usuario_curso", joinColumns = @JoinColumn(name = "usuarioId"), inverseJoinColumns = @JoinColumn(name = "cursoId"))
    private Set<Curso> cursos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(nombre, usuario.nombre) && Objects.equals(email, usuario.email) && apellidos.equals(usuario.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, apellidos);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", cursos=" + cursos +
                '}';
    }
}
