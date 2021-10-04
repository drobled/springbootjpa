package com.example.springboot.JPAMysql.config;

import com.example.springboot.JPAMysql.config.dto.MiUsuarioPrincipal;
import com.example.springboot.JPAMysql.entities.Usuario;
import com.example.springboot.JPAMysql.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MiUsuarioDetallesServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByNombre(s);
        if(usuario == null){
            throw new UsernameNotFoundException(s);
        }
        return new MiUsuarioPrincipal(usuario);
    }
}
