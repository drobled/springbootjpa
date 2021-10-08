package com.recompensas.ProyectoRecompensas.config;

import com.recompensas.ProyectoRecompensas.entities.Rol;
import com.recompensas.ProyectoRecompensas.entities.Usuario;
import com.recompensas.ProyectoRecompensas.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class MiUsuarioDetallesServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByDni(s);
        return new MiUsuarioPrincipal(usuario);
    }

}
