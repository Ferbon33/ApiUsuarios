package com.api.Usuarios.controller;

import com.api.Usuarios.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/guardar")
    public String guardar(String clave, String valor) {
        redisService.guardarDato(clave, valor);
        return "Guardado";
    }

    @GetMapping("/leer")
    public String leer(String clave) {
        return redisService.obtenerDato(clave);
    }

    @GetMapping("/guardarTTL")
    public String guardarTTL() {
        redisService.guardarConTTL("codigo", "ABC123", 60); // expira en 60 segundos
        return "Guardado con TTL";
    }
}
