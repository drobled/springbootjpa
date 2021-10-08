package com.recompensas.ProyectoRecompensas.controllers;

import com.recompensas.ProyectoRecompensas.entities.Usuario;
import com.recompensas.ProyectoRecompensas.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @RequestMapping(value = "/{dni}",method = RequestMethod.GET)
    public Usuario usuariobyDNI(@PathVariable("dni") String dni){
        return usuarioRepositorio.findByDni(dni);
    }

}
