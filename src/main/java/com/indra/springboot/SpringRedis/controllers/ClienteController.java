package com.indra.springboot.SpringRedis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
