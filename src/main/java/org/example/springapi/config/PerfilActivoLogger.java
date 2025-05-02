package org.example.springapi.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PerfilActivoLogger {

    private static final Logger logger = LoggerFactory.getLogger(PerfilActivoLogger.class);

    @Value("${spring.profiles.active:default}")
    private String perfilActivo;

    @PostConstruct
    public void mostrarPerfil() {
        logger.info("🔧 Perfil activo: " + perfilActivo);
    }
}
