package com.example.springboot.JPAMysql.listeners;

import com.example.springboot.JPAMysql.entities.Riesgo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

@Slf4j
public class RiesgoWriterListener implements ItemWriteListener<Riesgo> {
    @Override
    public void beforeWrite(List<? extends Riesgo> list) {
        log.info("Antes de leer");
    }

    @Override
    public void afterWrite(List<? extends Riesgo> list) {
        log.info("Despues de escribir");
    }

    @Override
    public void onWriteError(Exception e, List<? extends Riesgo> list) {
        log.info("Error en la escritura");
    }
}
