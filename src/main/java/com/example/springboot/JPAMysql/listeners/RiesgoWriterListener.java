package com.example.springboot.JPAMysql.listeners;

import com.example.springboot.JPAMysql.entities.Riesgo;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class RiesgoWriterListener implements ItemWriteListener<Riesgo> {
    @Override
    public void beforeWrite(List<? extends Riesgo> list) {

    }

    @Override
    public void afterWrite(List<? extends Riesgo> list) {

    }

    @Override
    public void onWriteError(Exception e, List<? extends Riesgo> list) {

    }
}
