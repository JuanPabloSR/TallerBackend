package com.sofka.pruebacrud.repositories;

import java.util.ArrayList;

import com.sofka.pruebacrud.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public static ArrayList<UsuarioModel> findByPrioridad(Integer prioridad) {
        // TODO Auto-generated method stub
        return null;
    }
} 