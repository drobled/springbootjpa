package com.recompensas.ProyectoRecompensas.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.recompensas.ProyectoRecompensas.entities.Usuario;
import com.recompensas.ProyectoRecompensas.repositories.UsuarioRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.Iterator;

@Configuration
@Slf4j
public class MongoDBConfig {
    @Value("classpath:usuarios.json")
    private Resource usuarios;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public void inicializar() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(usuarios.getURI().getPath()));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray usuariosList = (JSONArray) jsonObject.get("usuarios");
            Iterator<JSONObject> iterator = usuariosList.iterator();
            while (iterator.hasNext()) {
                jsonObject = iterator.next();
                Gson gson = new Gson();
                Usuario usuario = gson.fromJson(jsonObject.toJSONString(), Usuario.class);
                if (usuarioRepositorio.findByDni(usuario.getDni()) == null)
                    usuarioRepositorio.save(usuario);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
