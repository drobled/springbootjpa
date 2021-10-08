package com.recompensas.ProyectoRecompensas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacionController {

    @GetMapping(value="/")
    public String inicio(){
        return "index";
    }

    @GetMapping(value="/quienes")
    public String quienes(){
        return "quienes-somos";
    }

    @GetMapping(value="/acciones")
    public String acciones(){
        return "acciones";
    }

}
