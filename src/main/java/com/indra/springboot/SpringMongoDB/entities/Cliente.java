package com.indra.springboot.SpringMongoDB.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("clientes")
@Setter
@Getter
public class Cliente {

    @Id
    private String id;

    private String nombre;

    private String direccion;

    private List<Pelicula> peliculas;


}
