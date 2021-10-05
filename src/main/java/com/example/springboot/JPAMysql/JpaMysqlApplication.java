package com.example.springboot.JPAMysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JpaMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaMysqlApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String clave = encoder.encode("123");
		System.out.println("Servidor online " + clave);
	}

}
