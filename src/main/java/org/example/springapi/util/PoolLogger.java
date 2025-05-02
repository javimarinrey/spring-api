package org.example.springapi.util;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import org.example.springapi.controller.UsuarioController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class PoolLogger {

    private static final Logger logger = LoggerFactory.getLogger(PoolLogger.class);

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void mostrarInfo() {
        if (dataSource instanceof HikariDataSource ds) {
            logger.info("🔌 Pool activo: " + ds.getPoolName());
        }
    }
}
