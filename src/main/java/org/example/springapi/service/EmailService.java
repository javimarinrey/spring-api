package org.example.springapi.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class EmailService {
    private final TemplateEngine templateEngine;

    public EmailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generarHtmlCorreo(Map<String, Object> datos) {
        Context context = new Context();
        context.setVariables(datos);
        return templateEngine.process("correo/plantilla", context);
    }
}
