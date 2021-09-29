package com.example.springboot.JPAMysql.repositories;

import com.example.springboot.JPAMysql.entities.Curso;
import com.example.springboot.JPAMysql.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

    List<Usuario> findByNombreAndApellidos(String nombre, String apellidos);

    public Usuario findUsuarioByNombreEqualsAndEmailEqualsOrderByNombre(String nombre, String email);

    @Query(value="select * from usuario u where u.nombre = :nombre", nativeQuery = true)
    List<Usuario> getUsuariosCliente(String nombre);

}
