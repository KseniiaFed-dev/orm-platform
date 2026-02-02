ORM Platform

Учебный backend-проект на Spring Boot с использованием JPA (Hibernate).
Проект демонстрирует работу с ORM, REST API и слоистой архитектурой.

1. Технологии

-Java 23

-Spring Boot

-Spring Data JPA (Hibernate)

-H2 Database (dev)

-Maven

-Lombok

2.Функциональность

-Курсы с категориями

-Структура курса: Course → Module → Lesson

-Пользователи с ролями (TEACHER, STUDENT)

-Запись студентов на курсы (Many-to-Many через Enrollment)

-Задания и решения

-Квизы и ответы

3. REST API для основных операций

Валидация входных данных

Глобальная обработка ошибок

4. Архитектура

Проект разделён по слоям:

-entity — JPA сущности

-repository — Spring Data JPA

-service — бизнес-логика

-controller — REST API

-dto — объекты запросов и ответов

5. База данных

В режиме разработки используется H2 (in-memory).

JDBC URL: jdbc:h2:mem:orm_platform

H2 Console: /h2-console

Схема создаётся автоматически, демо-данные загружаются из data.sql.

6. Запуск
mvn clean spring-boot:run


Приложение запускается на http://localhost:8080.
