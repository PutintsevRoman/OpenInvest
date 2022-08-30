# Проект по автоматизации тестирования Открытие инвестиции
<a href="https://open-broker.ru/invest/"><img src="images/logo/Открытие.png" alt="OpenBroker"/></a>


## :gorilla: Содержание:

- [Технологии и инструменты](#peacock-технологии-и-инструменты)
- [Реализованные проверки](#earth_africa-Реализованные-проверки)
- [Сборка в Jenkins](#earth_africa-Jenkins-job)
- [Запуск из терминала](#earth_africa-Запуск-тестов-из-терминала)
- [Allure отчет](#earth_africa-Allure-отчет)
- [Отчет в Telegram](#earth_africa-Уведомление-в-Telegram-при-помощи-бота)
- [Видео примеры прохождения тестов](#earth_africa-Примеры-видео-о-прохождении-тестов)

## :peacock: Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/AllureTestOps.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/appium.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Rest-Assured.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/androidstudio.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Browserstack.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## :octopus: Реализованные проверки

- Набор разнообразных UI тестов
- Несколько API тестов
- Тесты на мобильное приложение "Открытие Обучение"

## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/10_DikayaAV_unit13/"> job </a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/013_Putintsev_14_Jenkins_Telegram/"><img src="images/Jenkins.PNG" alt="Jenkins"/></a>
</p>

### Параметры сборки в Jenkins:
- tag (Вид тестов WEB,API,Mobile) - обязательный параметр
- Host (Удаленно или локально) - обязательный параметр
- browser (браузер, по умолчанию chrome)
- version (версия браузера, по умолчанию 99.0)
- size (размер окна браузера, по умолчанию 1920x1080)

## Запуск тестов из терминала

Локальный запуск (UI тестов локально):
```
gradle clean test -Dtag=WEB -Dremote=false 
```

Удаленный запуск с Jenkins:
```
clean
test
-Dtag=${Tag}
-Dhost=${Host}
-Dbrowser=${Browser}
-DbrowserVersion=${Browser_version}
-DbrowserSize=${Browser_Size}
```
## <img src="images/logo/AllureTestOps.png" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://allure.autotests.cloud/project/1538/dashboards">Allure Test OPS</a>

### Страница проекта

<p align="center">
<img title="Allure Overview Dashboard" src="images/Первая страница.PNG">
</p>

### Страница запуска

<p align="center">
<img title="Allure Overview Dashboard" src="images/Главная_страница.PNG">
</p>

### Реализованные тесты

<p align="center">
<img title="Allure Overview Dashboard" src="images/Набор кейсов.PNG">
</p>

### Спсисок ошибок

<p align="center">
<img title="Allure Overview Dashboard" src="images/Список ошибок.PNG">
</p>

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/013_Putintsev_14_Jenkins_Telegram/23/allure/">Allure report</a>

### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/Allure.PNG">
</p>

### Тесты

<p align="center">
<img title="Allure Tests" src="images/Tests.PNG">
</p>

### Графики

<p align="center">
<img title="Allure Graphics" src="images/Graphs.PNG">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram при помощи бота

<p align="center">
<img title="Allure Overview Dashboard" src="images/Telegram.PNG" >
</p>


## <img src="images/logo/Selenoid.svg" width="25" height="25"  alt="Allure"/></a> Видео прохождения теста

<p align="center">
<img title="Selenoid Video" src="images/3a411e3c8853f2fb.gif" width="250" height="153"  alt="video">
<img title="Selenoid Video" src="images/b8d6d3f36c113950.gif" width="250" height="153"  alt="video"> 
<img title="Selenoid Video" src="images/cdbb275e1308bf2.gif" width="250" height="153"  alt="video"> 
</p>

## <img src="images/logo/Browserstack.svg" width="25" height="25"  alt="Allure"/></a> Видео прохождения мобильного теста

<p align="center">
<img title="Selenoid Video" src="images/browserstack.gif" alt="video">
</p>