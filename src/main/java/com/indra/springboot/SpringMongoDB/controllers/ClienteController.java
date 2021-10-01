package com.indra.springboot.SpringMongoDB.controllers;

import com.indra.springboot.SpringMongoDB.entities.Cliente;
import com.indra.springboot.SpringMongoDB.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @PostMapping("/alta")
    public String altaCliente(@RequestParam Map<String,String> parametros){
        Cliente cliente = new Cliente();
        cliente.setDireccion(parametros.get("direccion"));
        cliente.setId(parametros.get("id"));
        cliente.setNombre(parametros.get("nombre"));
        clienteRepositorio.save(cliente);
        return "Alta cliente correcta";
    }

}
