package com.example.springboot.JPAMysql.repositories;

import com.example.springboot.JPAMysql.entities.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepositorio extends CrudRepository<Curso, Integer> {

}
