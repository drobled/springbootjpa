package com.recompensas.ProyectoRecompensas.config;

import com.recompensas.ProyectoRecompensas.entities.Rol;
import com.recompensas.ProyectoRecompensas.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MiUsuarioPrincipal implements UserDetails {

    private Usuario usuario;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MiUsuarioPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> permisos = new ArrayList<>();
        for (Rol rol : usuario.getRoles()) {
            permisos.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return permisos;
    }

    @Override
    public String getPassword() {
        return usuario.getTelefono();
    }

    @Override
    public String getUsername() {
        return usuario.getDni();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
