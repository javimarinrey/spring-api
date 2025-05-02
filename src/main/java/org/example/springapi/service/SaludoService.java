package org.example.springapi.service;

import org.springframework.stereotype.Service;

@Service
public class SaludoService {
    public String generarSaludo(String nombre) {
        return "¡Hola, " + nombre + "! Bienvenido a Spring Boot con Thymeleaf.";
    }
}
