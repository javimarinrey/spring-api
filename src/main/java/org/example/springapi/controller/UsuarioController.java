package org.example.springapi.controller;

import org.example.springapi.dto.UsuarioDTO;
import org.example.springapi.model.User;
import org.example.springapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Value("${mensaje.entorno}")
    private String entorno;

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        int result = repository.save(user);
        if (result > 0) {
            logger.info("User created successfully");
            return ResponseEntity.ok("User created successfully");
        } else {
            logger.error("Error creating user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

}
