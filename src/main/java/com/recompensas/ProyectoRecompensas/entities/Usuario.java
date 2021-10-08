package com.recompensas.ProyectoRecompensas.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
@Document("usuarios")
public class Usuario {

    private String dni;

    private String telefono;

    private List<Rol> roles;

}
