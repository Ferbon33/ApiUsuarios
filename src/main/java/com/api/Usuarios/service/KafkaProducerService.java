package com.api.Usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "productos";

    public void enviarProducto(String productoJson) {
        kafkaTemplate.send(TOPIC, productoJson);
    }
}
