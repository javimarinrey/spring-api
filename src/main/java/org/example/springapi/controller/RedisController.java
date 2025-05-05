package org.example.springapi.controller;

import org.example.springapi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/saveString")
    public String saveString(@RequestParam String key, @RequestParam String value) {
        redisService.saveString(key, value);
        return "Valor guardado en Redis: " + key + " -> " + value;
    }

    // Ruta para obtener un valor desde Redis
    @GetMapping("/get")
    public ResponseEntity<String> getValueFromRedis(@RequestParam String key) {
        // Recupera el valor de Redis
        String value = redisService.getString(key);

        if (value == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Valor no encontrado para la clave: " + key);
        } else {
            return ResponseEntity.ok("Valor recuperado: " + value);
        }
    }


}
