package com.example.springboot.JPAMysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class JpaMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaMysqlApplication.class, args);
		System.out.println("Servidor online");
	}

}
