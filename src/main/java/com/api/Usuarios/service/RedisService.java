package com.api.Usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String obtenerDato(String clave) {
        return redisTemplate.opsForValue().get(clave);
    }

    public void guardarConTTL(String clave, String valor, long segundos) {
        redisTemplate.opsForValue().set(clave, valor, Duration.ofSeconds(segundos));
    }

    public void guardarDato(String clave, String valor) {
        redisTemplate.opsForValue().set(clave, valor);
    }
}
