package com.example.springboot.JPAMysql.listeners;

import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;

@Slf4j
public class TarjetaCreditoReaderListener implements ItemReadListener<TarjetaCredito> {


    @Override
    public void beforeRead() {
        log.info("Antes de leer");
    }

    @Override
    public void afterRead(TarjetaCredito tarjetaCredito) {
        log.info("Después de leer");
    }

    @Override
    public void onReadError(Exception e) {
        log.info("Error en la lectura");
    }
}
