package com.recompensas.ProyectoRecompensas.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private String dni;

    private String telefono;

    private List<RolDTO> roles;

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", roles=" + roles +
                '}';
    }
}
