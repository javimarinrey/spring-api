package org.example.springapi.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages"); // nombre base sin extensión
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true); // opcional: usa la clave si no hay traducción
        return source;
    }
}