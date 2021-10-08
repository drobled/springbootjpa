package com.recompensas.ProyectoRecompensas.repositories;

import com.recompensas.ProyectoRecompensas.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

    public Usuario findByDni(String dni);

}
