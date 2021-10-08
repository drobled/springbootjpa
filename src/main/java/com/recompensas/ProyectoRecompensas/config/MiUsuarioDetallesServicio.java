package com.recompensas.ProyectoRecompensas.config;

import com.recompensas.ProyectoRecompensas.dto.UsuarioDTO;
import com.recompensas.ProyectoRecompensas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MiUsuarioDetallesServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsuarioDTO usuario = usuarioRepositorio.getUsuario(s);
        return new MiUsuarioPrincipal(usuario);
    }

}
