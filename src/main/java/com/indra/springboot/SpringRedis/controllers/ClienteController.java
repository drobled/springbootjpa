package com.indra.springboot.SpringRedis.controllers;

import com.indra.springboot.SpringRedis.entities.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private RedisTemplate<String, Libro> redisTemplate;

    @PostMapping("/alta")
    public String altaLibro(@RequestParam Map<String, String> parametros) {
        Libro libro = new Libro();
        libro.setTitulo(parametros.get("titulo"));
        libro.setIsbn(parametros.get("isbn"));
        redisTemplate.opsForValue().set(libro.getIsbn(),libro);
        return "Alta cliente correcta";
    }

    @GetMapping("/listarLibro/{idLibro}")
    public Libro listarLibro(@PathVariable("idLibro") String idLibro){
        Libro libro = redisTemplate.opsForValue().get(idLibro);
        return libro;
    }



}
