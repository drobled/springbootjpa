package com.example.springboot.JPAMysql.listeners;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

@Slf4j
public class TarjetaCreditoExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Antes de empezar");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Despues de terminar");
    }
}
