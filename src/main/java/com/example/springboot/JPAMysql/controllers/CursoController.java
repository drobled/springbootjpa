package com.example.springboot.JPAMysql.controllers;


import com.example.springboot.JPAMysql.entities.*;
import com.example.springboot.JPAMysql.repositories.AsignaturaRepositorio;
import com.example.springboot.JPAMysql.repositories.CursoRepositorio;
import com.example.springboot.JPAMysql.repositories.OpinionRepositorio;
import com.example.springboot.JPAMysql.repositories.UsuarioRepositorio;
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
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private AsignaturaRepositorio asignaturaRepositorio;

    @Autowired
    private OpinionRepositorio opinionRepositorio;

    @GetMapping("/listarCursos")
    public Iterable<Curso> getAllCursos() {
        return cursoRepositorio.findAll();
    }

    @PutMapping("/agregarAsignatura/{idCurso}")
    public String agregarAsignatura(@RequestParam String nombre, @PathVariable int idCurso) {
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(nombre);
        asignatura = asignaturaRepositorio.save(asignatura);
        Curso curso = cursoRepositorio.findById(idCurso).get();
        if (curso == null)
            return "Curso no existe";
        curso.getAsignaturas().add(asignatura);
        cursoRepositorio.save(curso);
        return "Curso y asignatura asignado correctamente";
    }

    @PutMapping("/agregarOpinion/{idCurso}/{idUsuario}")
    public String agregarOpinion(@RequestParam String mensaje, @PathVariable int idCurso, @PathVariable int idUsuario) {
        Opinion opinion = new Opinion();
        OpinionClave opinionClave = new OpinionClave(idUsuario,idCurso);
        opinion.setId(opinionClave);
        opinion.setMensaje(mensaje);
        opinionRepositorio.save(opinion);
        return "Opinion ingresada correctamente";
    }


    @PostMapping("/agregarCurso")
    public String saveCurso(@RequestParam Map<String, String> params) {
        Curso curso = new Curso();
        curso.setNombre(params.get("nombre"));
        cursoRepositorio.save(curso);
        return "Salvado correctamente";
    }


}
