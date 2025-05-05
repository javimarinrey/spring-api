package org.example.springapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);  // Guardar un valor en Redis
    }

    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);  // Obtener un valor de Redis
    }

    public void increment(String key, long delta) {
        redisTemplate.opsForValue().increment(key, delta);  // Incrementar un valor en Redis
    }

    public void deleteString(String key) {
        redisTemplate.delete(key);  // Eliminar una clave de Redis
    }
}
