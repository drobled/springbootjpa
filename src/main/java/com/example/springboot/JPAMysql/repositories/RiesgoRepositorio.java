package com.example.springboot.JPAMysql.repositories;

import com.example.springboot.JPAMysql.entities.Riesgo;
import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiesgoRepositorio extends JpaRepository<Riesgo, Long> {
}
