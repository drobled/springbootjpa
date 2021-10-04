package com.example.springboot.JPAMysql.repositories;

import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaCreditoRepositorio extends JpaRepository<TarjetaCredito,Long> {
}
