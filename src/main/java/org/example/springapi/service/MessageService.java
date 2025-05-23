package org.example.springapi.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String key, Locale locale) {
        return messageSource.getMessage("greeting", null, locale);
    }
}
