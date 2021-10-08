package com.recompensas.ProyectoRecompensas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO implements Serializable {

    private String nombre;

    @Override
    public String toString() {
        return "RolDTO{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
