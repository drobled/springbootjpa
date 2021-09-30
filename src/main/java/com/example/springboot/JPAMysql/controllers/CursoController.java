package com.example.springboot.JPAMysql.controllers;


import com.example.springboot.JPAMysql.entities.Asignatura;
import com.example.springboot.JPAMysql.entities.Curso;
import com.example.springboot.JPAMysql.repositories.AsignaturaRepositorio;
import com.example.springboot.JPAMysql.repositories.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Autowired
    private AsignaturaRepositorio asignaturaRepositorio;

    @GetMapping("/listarCursos")
    public Iterable<Curso> getAllCursos(){
        return cursoRepositorio.findAll();
    }

    @PutMapping("/agregarAsignatura/{idCurso}")
    public String agregarAsignatura(@RequestParam String nombre,@PathVariable int idCurso){
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(nombre);
        asignatura = asignaturaRepositorio.save(asignatura);
        Curso curso = cursoRepositorio.findById(idCurso).get();
        if(curso == null)
            return "Curso no existe";
        curso.getAsignaturas().add(asignatura);
        cursoRepositorio.save(curso);
        return "Curso y asignatura asignado correctamente";
    }

    @PostMapping("/agregarOpinion")
    


    @PostMapping("/agregarCurso")
    public String saveCurso(@RequestParam Map<String,String> params){
        Curso curso = new Curso();
        curso.setNombre(params.get("nombre"));
        cursoRepositorio.save(curso);
        return "Salvado correctamente";
    }


}
