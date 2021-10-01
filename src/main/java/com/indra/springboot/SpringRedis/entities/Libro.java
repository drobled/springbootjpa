package com.indra.springboot.SpringRedis.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Libro implements Serializable {

    private String isbn;

    private String titulo;

}
