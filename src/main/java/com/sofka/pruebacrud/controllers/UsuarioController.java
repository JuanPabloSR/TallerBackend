package com.sofka.pruebacrud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.sofka.pruebacrud.models.UsuarioModel;
import com.sofka.pruebacrud.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    // metodo para obtener usuarios

    @GetMapping()
    public ArrayList<UsuarioModel> obteneUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    // metodo para guardar usuarios
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obteneUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obteneUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    //Eliminar usuario por Id

    @DeleteMapping (path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "se elimino el usario con id " + id;
        } else {
            return "No se piede eliminar el usuario con el id " +id;
        }
    }

    @PutMapping
    public String actualizar(@RequestBody UsuarioModel usuario){
        usuarioService.update(usuario);
        return ("Usuario con id: " + usuario.getId() + " Actualizado!!");
    }
    
    // eliminar todos los registros de una vez 

    @DeleteMapping( path = "/all")
    public String eliminarTodo(){
        boolean ok = this.usuarioService.eliminarTodo();
        if(ok){
            return "Se eliminaron todos los registros de usuario de la tabla";
        } else {
            return "No se pudo completar el proceso de eliminación";
        }
    }

}
