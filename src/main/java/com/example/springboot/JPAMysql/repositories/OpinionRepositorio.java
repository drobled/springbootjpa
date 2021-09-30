package com.example.springboot.JPAMysql.repositories;

import com.example.springboot.JPAMysql.entities.Curso;
import com.example.springboot.JPAMysql.entities.Opinion;
import com.example.springboot.JPAMysql.entities.OpinionClave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepositorio extends JpaRepository<Opinion, OpinionClave> {

}
