package com.example.springboot.JPAMysql.jobs;

import com.example.springboot.JPAMysql.entities.Riesgo;
import com.example.springboot.JPAMysql.repositories.RiesgoRepositorio;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TarjetaCreditoWriter implements ItemWriter<Riesgo> {

    @Autowired
    private RiesgoRepositorio riesgoRepositorio;

    @Override
    public void write(List<? extends Riesgo> list) throws Exception {
        riesgoRepositorio.saveAll(list);
    }
}
