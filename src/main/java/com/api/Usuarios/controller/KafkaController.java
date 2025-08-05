package com.api.Usuarios.controller;

import com.api.Usuarios.Dto.Product;
import com.api.Usuarios.service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/productos")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<String> enviarProducto(@RequestBody Product producto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String productoJson = mapper.writeValueAsString(producto);

        kafkaProducerService.enviarProducto(productoJson);
        return ResponseEntity.ok("Producto enviado a Kafka ✅");
    }
}
