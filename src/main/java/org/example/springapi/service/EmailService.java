package org.example.springapi.service;

import com.itextpdf.html2pdf.HtmlConverter;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.util.Map;

@Service
public class EmailService {
    private final TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender mailSender;

    public EmailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generarHtmlCorreo(Map<String, Object> datos) {
        Context context = new Context();
        context.setVariables(datos);
        return templateEngine.process("correo/plantilla", context);
    }

    public void sendEmail() throws MessagingException {

        String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
                "<p>It can contain <strong>HTML</strong> content.</p>";

        // 1. Convertir HTML a PDF en memoria
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(htmlContent, pdfOutputStream);
        byte[] pdfBytes = pdfOutputStream.toByteArray();

        // 2. Crear email
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom("informatica@hotusa.es");
        helper.setTo("javier.marin@igmweb.com");
        helper.setSubject("test");
        helper.setText(htmlContent, true);

        // 3. Adjuntar PDF
        helper.addAttachment("contenido.pdf", new ByteArrayResource(pdfBytes));

        // 4. Enviar
        mailSender.send(message);
    }
}
