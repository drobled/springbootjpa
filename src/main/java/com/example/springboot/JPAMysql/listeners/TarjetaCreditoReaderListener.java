package com.example.springboot.JPAMysql.listeners;

import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import org.springframework.batch.core.ItemReadListener;

public class TarjetaCreditoReaderListener implements ItemReadListener<TarjetaCredito> {


    @Override
    public void beforeRead() {

    }

    @Override
    public void afterRead(TarjetaCredito tarjetaCredito) {

    }

    @Override
    public void onReadError(Exception e) {

    }
}
