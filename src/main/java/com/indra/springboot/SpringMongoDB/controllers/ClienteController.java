package com.indra.springboot.SpringMongoDB.controllers;

import com.indra.springboot.SpringMongoDB.entities.Cliente;
import com.indra.springboot.SpringMongoDB.entities.Pelicula;
import com.indra.springboot.SpringMongoDB.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @PostMapping("/alta")
    public String altaCliente(@RequestParam Map<String, String> parametros) {
        Cliente cliente = new Cliente();
        cliente.setDireccion(parametros.get("direccion"));
        cliente.setId(parametros.get("id"));
        cliente.setNombre(parametros.get("nombre"));
        clienteRepositorio.save(cliente);
        return "Alta cliente correcta";
    }

    @PutMapping("/altaPelicula/{idCliente}")
    public String altaPelicula(@PathVariable("idCliente") String idCliente, @RequestParam String titulo) {
        Cliente cliente = clienteRepositorio.findById(idCliente).get();
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(titulo);
        if(cliente.getPeliculas() == null)
            cliente.setPeliculas(new ArrayList<>());
        cliente.getPeliculas().add(pelicula);
        clienteRepositorio.save(cliente);
        return "Alta pelicula correcta";
    }

}
