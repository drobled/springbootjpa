package com.example.springboot.JPAMysql.jobs;

import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import com.example.springboot.JPAMysql.repositories.TarjetaCreditoRepositorio;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class TarjetaCreditoReader implements ItemReader<TarjetaCredito> {

    @Autowired
    private TarjetaCreditoRepositorio tarjetaCreditoRepositorio;

    private Iterator<TarjetaCredito> tarjetaCreditoIterator;

    @BeforeStep
    public void before(StepExecution stepExecution){
        tarjetaCreditoIterator = tarjetaCreditoRepositorio.findAll().iterator();
    }

    @Override
    public TarjetaCredito read(){
        if(tarjetaCreditoIterator != null && tarjetaCreditoIterator.hasNext()){
            return tarjetaCreditoIterator.next();
        }else{
            return null;
        }
    }

}
