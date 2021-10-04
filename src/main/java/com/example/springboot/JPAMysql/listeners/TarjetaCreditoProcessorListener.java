package com.example.springboot.JPAMysql.listeners;

import com.example.springboot.JPAMysql.entities.Riesgo;
import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;

@Slf4j
public class TarjetaCreditoProcessorListener implements ItemProcessListener<TarjetaCredito, Riesgo> {

    @Override
    public void beforeProcess(TarjetaCredito tarjetaCredito) {
        log.info("Antes de procesar");
    }

    @Override
    public void afterProcess(TarjetaCredito tarjetaCredito, Riesgo riesgo) {
        log.info("Después de procesar");
    }

    @Override
    public void onProcessError(TarjetaCredito tarjetaCredito, Exception e) {
        log.info("Error en el procesamiento");
    }
}
