package com.api.Usuarios.controller;


import com.api.Usuarios.models.UsuarioPosgres;
import com.api.Usuarios.service.UsuarioPosgresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuariosPosgres")
public class PosgresController {

    private final UsuarioPosgresService service;

    public PosgresController(UsuarioPosgresService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioPosgres> getAllUsuarios() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioPosgres> getUsuarioById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioPosgres createUsuario(@RequestBody UsuarioPosgres usuario) {
        return service.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioPosgres> updateUsuario(@PathVariable Long id, @RequestBody UsuarioPosgres usuarioDetails) {
        return service.findById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioDetails.getNombre());
                    usuario.setEmail(usuarioDetails.getEmail());
                    return ResponseEntity.ok(service.save(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        return service.findById(id)
                .map(usuario -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
