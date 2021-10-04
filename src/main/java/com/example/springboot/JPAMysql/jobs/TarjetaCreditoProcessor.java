package com.example.springboot.JPAMysql.jobs;

import com.example.springboot.JPAMysql.entities.Riesgo;
import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import org.springframework.batch.item.ItemProcessor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TarjetaCreditoProcessor implements ItemProcessor<TarjetaCredito, Riesgo> {

    @Override
    public Riesgo process(TarjetaCredito tarjetaCredito){
        LocalDate hoy = LocalDate.now();
        LocalDate ultimaFecha = tarjetaCredito.getUltimoPago().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long diasEntreMedias = Duration.between(hoy,ultimaFecha).toDays();

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
