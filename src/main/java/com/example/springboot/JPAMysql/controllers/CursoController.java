package com.example.springboot.JPAMysql.controllers;


import com.example.springboot.JPAMysql.entities.Curso;
import com.example.springboot.JPAMysql.repositories.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @GetMapping("/listarCursos")
    public Iterable<Curso> getAllCursos(){
        return cursoRepositorio.findAll();
    }

    @PostMapping("/agregarCurso")
    public String saveCurso(@RequestParam Map<String,String> params){
        Curso curso = new Curso();
        curso.setNombre(params.get("nombre"));
        cursoRepositorio.save(curso);
        return "Salvado correctamente";
    }


}
