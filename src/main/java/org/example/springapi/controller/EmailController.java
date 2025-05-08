package org.example.springapi.controller;

import jakarta.mail.MessagingException;
import org.example.springapi.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> createEmail() {

        Map<String, Object> datos = new HashMap<>();
        datos.put("nombre", "Javi");
        datos.put("pedidoId", "1234");
        String contenido = emailService.generarHtmlCorreo(datos);
        logger.info(contenido);
        return ResponseEntity.ok("Email created successfully");
    }

    @GetMapping
    public ResponseEntity sendEmail() throws MessagingException {
        emailService.sendEmail();
        return ResponseEntity.ok().build();
    }

}
