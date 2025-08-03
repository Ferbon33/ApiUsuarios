package com.api.Usuarios.repository;

import com.api.Usuarios.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // Podés agregar consultas personalizadas si querés
}
