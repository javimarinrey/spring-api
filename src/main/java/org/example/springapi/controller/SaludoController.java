package org.example.springapi.controller;

import org.example.springapi.service.SaludoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaludoController {
    private final SaludoService saludoService;

    public SaludoController(SaludoService saludoService) {
        this.saludoService = saludoService;
    }

    @GetMapping("/")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/saludar")
    public String procesarFormulario(@RequestParam String nombre, Model model) {
        String mensaje = saludoService.generarSaludo(nombre);
        model.addAttribute("mensaje", mensaje);
        return "resultado";
    }
}
