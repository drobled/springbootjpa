package com.recompensas.ProyectoRecompensas.repositories;

import com.recompensas.ProyectoRecompensas.entities.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaRepositorio extends MongoRepository<Empresa, String> {

}
