package org.example.springapi.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PerfilActivoLogger {

    private static final Logger logger = LoggerFactory.getLogger(PerfilActivoLogger.class);

    private final Environment env;

    public PerfilActivoLogger(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void mostrarPerfilActivo() {
        String[] perfiles = env.getActiveProfiles();
        if (perfiles.length == 0) {
            logger.info("⚠️  No hay perfil activo. Usando el perfil por defecto.");
        } else {
            logger.info("✅ Perfil activo: " + String.join(", ", perfiles));
        }
    }
}
