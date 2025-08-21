package com.api.Usuarios.repository;

import com.api.Usuarios.models.UsuarioPosgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface UsuarioRepositoryPosgres extends JpaRepository<UsuarioPosgres, Long> {

}
