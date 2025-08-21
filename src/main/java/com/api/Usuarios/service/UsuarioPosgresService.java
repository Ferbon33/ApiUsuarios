package com.api.Usuarios.service;

import com.api.Usuarios.models.UsuarioPosgres;
import com.api.Usuarios.repository.UsuarioRepository;
import com.api.Usuarios.repository.UsuarioRepositoryPosgres;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioPosgresService {

    private final UsuarioRepositoryPosgres repository;

    public UsuarioPosgresService(UsuarioRepositoryPosgres repository) {
        this.repository = repository;
    }

    public List<UsuarioPosgres> findAll() {
        return repository.findAll();
    }

    public Optional<UsuarioPosgres> findById(Long id) {
        return repository.findById(id);
    }

    public UsuarioPosgres save(UsuarioPosgres usuario) {
        return repository.save(usuario);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
