# Sprint_4

Учебный проект по автотестированию UI для приложения по заказу самокатов Яндекс.Самокат.

## Описание

Версия Java 11.

В проекте тестируется функциональность в Google Chrome и Mozilla Firefox.
Также ловится баг после ввода всех данных при заказе самоката в Google Chrome.

Проект использует следующие библиотеки:
- JUnit 4
- Selenium

## Документация

[Ссылка](https://qa-scooter.praktikum-services.ru/) на учебное приложение.

### Запуск автотестов

Для запуска автотестов необходимо:

1. Скачать код

 ```sh
   git clone https://github.com/ManaskinaTatyanaSergeevna/Sprint_4.git
   ```
   
2. Запустить команду в проекте

```sh
mvn clean test
```

### Структура проекта

```bash
.gitignore
pom.xml
README.md
   src
   |-- main
   |   |-- java
   |   |   |-- pages
   |   |   |   |-- MainPage.java
   |   |   |   |-- MetroHomePage.java
   |   |   |   |-- OrderPage.java
   |-- test
   |   |-- java
   |   |   |-- MainPageTest.java
   |   |   |-- OrderTest.java
   ```
