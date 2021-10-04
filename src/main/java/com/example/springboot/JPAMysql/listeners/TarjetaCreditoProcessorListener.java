package com.example.springboot.JPAMysql.listeners;

import com.example.springboot.JPAMysql.entities.Riesgo;
import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import org.springframework.batch.core.ItemProcessListener;

public class TarjetaCreditoProcessorListener implements ItemProcessListener<TarjetaCredito, Riesgo> {

    @Override
    public void beforeProcess(TarjetaCredito tarjetaCredito) {

    }

    @Override
    public void afterProcess(TarjetaCredito tarjetaCredito, Riesgo riesgo) {

    }

    @Override
    public void onProcessError(TarjetaCredito tarjetaCredito, Exception e) {

    }
}
