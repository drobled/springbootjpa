package com.recompensas.ProyectoRecompensas.config;

import com.recompensas.ProyectoRecompensas.entities.Rol;
import com.recompensas.ProyectoRecompensas.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class MiUsuarioDetallesServicio implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = new Usuario();
        usuario.setDni("123");
        usuario.setTelefono("321");
        usuario.setRoles(new ArrayList<>());
        usuario.getRoles().add(new Rol("USER"));
        return new MiUsuarioPrincipal(usuario);
    }

}
