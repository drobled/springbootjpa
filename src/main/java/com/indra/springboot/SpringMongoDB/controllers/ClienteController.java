package com.indra.springboot.SpringMongoDB.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PostMapping("/alta")
    public String altaCliente(@RequestParam Map<String, String> parametros) {

        return "Alta cliente correcta";
    }



}
