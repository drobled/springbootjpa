package com.recompensas.ProyectoRecompensas.repositorio;

import com.recompensas.ProyectoRecompensas.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableDiscoveryClient
@Configuration
@EnableFeignClients
@Service
public class UsuarioRepositorio {

    @Autowired
    private BackRecompensa backRecompensa;

    @FeignClient("BackRecompensa")
    interface BackRecompensa{
        @RequestMapping(value = "/usuarios/{dni}",method = RequestMethod.GET)
        public UsuarioDTO usuariobyDNI(@PathVariable("dni") String dni);
    }

    public UsuarioDTO getUsuario(String dni){
        return backRecompensa.usuariobyDNI(dni);
    }

}
