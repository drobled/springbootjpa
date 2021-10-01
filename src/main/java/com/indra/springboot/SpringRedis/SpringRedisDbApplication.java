package com.indra.springboot.SpringRedis;

import com.indra.springboot.SpringRedis.entities.Libro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringRedisDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisDbApplication.class, args);
	}

	@Bean
	public RedisTemplate<String, Libro> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String,Libro> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}

}
