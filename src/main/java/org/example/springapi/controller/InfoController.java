package org.example.springapi.controller;

import org.example.springapi.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final AppProperties appProperties;

    public InfoController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/info")
    public String info() {
        return "App: " + appProperties.getName() + ", version: " + appProperties.getVersion();
    }
}
