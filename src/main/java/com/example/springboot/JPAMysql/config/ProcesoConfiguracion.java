package com.example.springboot.JPAMysql.config;

import com.example.springboot.JPAMysql.entities.Riesgo;
import com.example.springboot.JPAMysql.entities.TarjetaCredito;
import com.example.springboot.JPAMysql.jobs.TarjetaCreditoProcessor;
import com.example.springboot.JPAMysql.jobs.TarjetaCreditoReader;
import com.example.springboot.JPAMysql.jobs.TarjetaCreditoWriter;
import com.example.springboot.JPAMysql.listeners.RiesgoWriterListener;
import com.example.springboot.JPAMysql.listeners.TarjetaCreditoExecutionListener;
import com.example.springboot.JPAMysql.listeners.TarjetaCreditoProcessorListener;
import com.example.springboot.JPAMysql.listeners.TarjetaCreditoReaderListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ProcesoConfiguracion {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;


    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public TarjetaCreditoReader reader() {
        return new TarjetaCreditoReader();
    }

    @Bean
    public TarjetaCreditoProcessor processor() {
        return new TarjetaCreditoProcessor();
    }

    @Bean
    public TarjetaCreditoWriter writer() {
        return new TarjetaCreditoWriter();
    }

    @Bean
    public TarjetaCreditoExecutionListener jobExecutionListener() {
        return new TarjetaCreditoExecutionListener();
    }

    @Bean
    public TarjetaCreditoProcessorListener processorListener() {
        return new TarjetaCreditoProcessorListener();
    }

    @Bean
    public TarjetaCreditoReaderListener readerListener(){
        return new TarjetaCreditoReaderListener();
    }

    @Bean
    public RiesgoWriterListener writerListener(){
        return new RiesgoWriterListener();
    }
    
    @Bean
    public Job job(Step paso,TarjetaCreditoExecutionListener tarjetaCreditoExecutionListener){
        Job job = jobBuilderFactory.get("trabajo1")
                .listener(tarjetaCreditoExecutionListener)
                .flow(paso)
                .end()
                .build();
        return job;
    }

    @Bean
    public Step step(TarjetaCreditoReader tarjetaCreditoReader,
                     TarjetaCreditoWriter tarjetaCreditoWriter,
                     TarjetaCreditoProcessor tarjetaCreditoProcessor,
                     TarjetaCreditoReaderListener tarjetaCreditoReaderListener,
                     TarjetaCreditoProcessorListener tarjetaCreditoProcessorListener,
                     RiesgoWriterListener riesgoWriterListener){
        TaskletStep step = stepBuilderFactory.get("paso1")
                .<TarjetaCredito, Riesgo>chunk(100)
                .reader(tarjetaCreditoReader)
                .processor(tarjetaCreditoProcessor)
                .writer(tarjetaCreditoWriter)
                .listener(tarjetaCreditoReaderListener)
                .listener(tarjetaCreditoProcessorListener)
                .listener(riesgoWriterListener)
                .build();
        return step;
    }

}
