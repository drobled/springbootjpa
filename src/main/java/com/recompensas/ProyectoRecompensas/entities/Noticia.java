package com.recompensas.ProyectoRecompensas.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("noticia")
@Setter
@Getter
public class Noticia {

    private String titulo;
    private Date fecha;
    private String autor;
    private String texto;

}
