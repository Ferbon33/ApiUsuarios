package com.api.Usuarios.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "productos", groupId = "grupo-productos")
    public void consumir(String mensaje) {
        System.out.println("📩 Mensaje recibido: " + mensaje);
    }
}
