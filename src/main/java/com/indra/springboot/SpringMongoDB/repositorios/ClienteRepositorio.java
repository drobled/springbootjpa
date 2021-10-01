package com.indra.springboot.SpringMongoDB.repositorios;

import com.indra.springboot.SpringMongoDB.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepositorio extends MongoRepository<Cliente, String> {
}
