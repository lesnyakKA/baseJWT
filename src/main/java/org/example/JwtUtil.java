package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // Секретный ключ для подписи JWT
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Время жизни токена (1 час)
    private static final long EXPIRATION_TIME = 3600000; // 1 час в миллисекундах

    // Создание JWT
    public static String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username) // Устанавливаем subject (обычно это username)
            .setIssuedAt(new Date()) // Устанавливаем время создания токена
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Устанавливаем срок действия
            .signWith(SECRET_KEY) // Подписываем токен
            .compact(); // Преобразуем в строку
    }

    // Проверка и извлечение данных из JWT
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY) // Устанавливаем ключ для проверки подписи
            .build()
            .parseClaimsJws(token) // Парсим токен
            .getBody(); // Получаем данные (claims)
    }

    // Проверка валидности токена
    public static boolean validateToken(String token) {
        try {
            parseToken(token); // Пытаемся распарсить токен
            return true; // Если успешно, токен валиден
        } catch (Exception e) {
            return false; // Если возникла ошибка, токен невалиден
        }
    }
}