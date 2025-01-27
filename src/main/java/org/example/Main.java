package org.example;

import io.jsonwebtoken.Claims;

public class Main {
    public static void main(String[] args) {
        // Генерация токена
        String username = "user123";
        String token = JwtUtil.generateToken(username);
        System.out.println("Сгенерированный токен: " + token);

        // Проверка токена
        if (JwtUtil.validateToken(token)) {
            System.out.println("Токен валиден.");

            // Извлечение данных из токена
            Claims claims = JwtUtil.parseToken(token);
            System.out.println("Данные из токена:");
            System.out.println("Subject (username): " + claims.getSubject());
            System.out.println("Выдан: " + claims.getIssuedAt());
            System.out.println("Истекает: " + claims.getExpiration());
        } else {
            System.out.println("Токен невалиден.");
        }
    }
}