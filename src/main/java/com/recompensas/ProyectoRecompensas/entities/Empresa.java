package com.recompensas.ProyectoRecompensas.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("empresas")
@Setter
@Getter
public class Empresa {

    private List<Trabajador> trabajadores;

    private List<Cliente> clientes;

}
