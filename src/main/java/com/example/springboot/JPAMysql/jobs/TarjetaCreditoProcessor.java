package com.example.springboot.JPAMysql.jobs;

import com.example.springboot.JPAMysql.entities.Riesgo;
import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import org.springframework.batch.item.ItemProcessor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class TarjetaCreditoProcessor implements ItemProcessor<TarjetaCredito, Riesgo> {

    @Override
    public Riesgo process(TarjetaCredito tarjetaCredito){
        LocalDate hoy = LocalDate.now();
        LocalDate ultimaFecha = tarjetaCredito.getUltimoPago().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(hoy,ultimaFecha);
        int diasEntreMedias = Math.abs(period.getDays());

        int riesgoI;

        if(diasEntreMedias >= 20){
            riesgoI = Riesgo.ALTO;
        }else if(diasEntreMedias > 10){
            riesgoI = Riesgo.BAJO;
        }else{
            riesgoI = Riesgo.NORMAL;
        }

        Riesgo riesgo = new Riesgo();
        riesgo.setTarjetaCredito(tarjetaCredito);
        riesgo.setFecha(new Date());
        riesgo.setPuntuacion(riesgoI);

        return riesgo;
    }

}
