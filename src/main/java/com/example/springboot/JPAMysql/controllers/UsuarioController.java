package com.example.springboot.JPAMysql.controllers;

import java.text.ParseException;

import com.example.springboot.JPAMysql.beans.UsuarioView;
import com.example.springboot.JPAMysql.entities.Curso;
import com.example.springboot.JPAMysql.entities.Usuario;
import com.example.springboot.JPAMysql.repositories.CursoRepositorio;
import com.example.springboot.JPAMysql.repositories.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @GetMapping("/inicio")
    public String inicio() {
        return "INCIO API REST";
    }

    @GetMapping("/listar")
    public List<UsuarioView> getAllUsers(){
        List<UsuarioView> retorno = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Usuario usuario:usuarioRepositorio.findAll()) {
            UsuarioView usuarioView = modelMapper.map(usuario,UsuarioView.class);
            retorno.add(usuarioView);
        }
        return retorno;
    }

    @PostMapping("/agregar")
    public String saveUser ( @RequestParam String nombre,
                             @RequestParam( name = "surname",
                                     required = false,
                                     defaultValue = "0000000") String apellido,
                             @RequestParam String email
                             )
    {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellido);
        usuario.setEmail(email);
        //Manejo de la fecha de creacion de usuario
        usuario.setFechaCreacion( new Date());

        usuarioRepositorio.save(usuario);

        return "Usuario guardado correctamente";
    }


    @PostMapping("/agregar2")
    public String saveUser2 ( @RequestParam Map<String,String> parametros )
    {
        Usuario usuario = new Usuario();
        usuario.setNombre(parametros.get("nombre"));
        usuario.setApellidos(parametros.get("apellido"));
        usuario.setEmail(parametros.get("email"));
        //Manejo de la fecha de creacion de usuario
        usuario.setFechaCreacion( new Date());

        usuarioRepositorio.save(usuario);

        return "Usuario guardado correctamente forma 2";
    }

    @PutMapping("/incluirCurso/{idUsuario}/{idCurso}")
    public String incluirCurso(@PathVariable int idUsuario,@PathVariable int idCurso){
        Curso curso = null;
        try {
            curso = cursoRepositorio.findById(idCurso).get();
        }catch (Exception e) {
            return "Error recuperando informacion del curso";
        }
        Usuario usuario =null;
        try {
            usuario = usuarioRepositorio.findById(idUsuario).get();
        }catch (Exception e) {
            return "Error recuperando informacion del usuario";
        }
        usuario.getCursos().add(curso);
        usuarioRepositorio.save(usuario);
        return "Curso incluido correctamente";
    }

    @PutMapping("/editar/{id}")
    public String editUser( @PathVariable String id, @RequestBody Usuario user  ){

        System.out.println(user.toString());

        Usuario usuarioEncontrado = usuarioRepositorio.
                findById( Integer.parseInt(id)).orElse(null);

        if( usuarioEncontrado == null){
            return "Usuario no encontrado";
        }else {
            usuarioEncontrado.setNombre(user.getNombre());
            usuarioEncontrado.setApellidos(user.getApellidos());
            usuarioEncontrado.setEmail(user.getEmail());
            usuarioEncontrado.setFechaCreacion( new Date());

            usuarioRepositorio.save(usuarioEncontrado);
            return "Usuario actualizado";
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteUser(@PathVariable String id){

        Usuario usuarioEncontrado = usuarioRepositorio.
                findById( Integer.parseInt(id) ).orElse(null);
        if( usuarioEncontrado == null){
            return "No exite el usuario en base de datos";
        }else{
            //usuarioRepositorio.deleteById(Integer.parseInt(id));
            usuarioRepositorio.delete(usuarioEncontrado);
            return "Usuario eliminado";
        }

    }

    @GetMapping("/buscar/{nombre}/{apellido}")
    public List<Usuario> getAllUsersByName( @PathVariable String nombre, @PathVariable String apellido ){
        return usuarioRepositorio.findByNombreAndApellidos(nombre, apellido);
    }

}
