# baseJWT
Пример проекта, который демонстрирует создание и проверку JWT.

Как это работает
1) Генерация токена:

2) Используется метод generateToken, который создает JWT с указанным username и временем жизни.

3) Токен подписывается с использованием секретного ключа (SECRET_KEY).

4) Проверка токена:

5) Метод validateToken проверяет, что токен валиден (не истек и подпись корректна).

6) Метод parseToken извлекает данные из токена (например, username).

7) Секретный ключ:

8) Ключ генерируется с использованием Keys.secretKeyFor. В реальных проектах ключ должен храниться в безопасном месте (например, в конфигурации сервера).