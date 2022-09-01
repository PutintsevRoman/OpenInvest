# Проект по автоматизации тестирования Открытие инвестиции
<a href="https://open-broker.ru/invest/"><img src="images/logo/Открытие.png" alt="OpenBroker"/></a>


## Содержание:

- [Технологии и инструменты](#Technology)
- [Реализованные проверки](#Checks)
- [Сборка в Jenkins](#Jenkins)
- [Запуск из терминала](#RemoteLaunch)
- [Allure TestOps отчет](#AllureTestOps)
- [Allure отчет](#Allure)
- [Отчет в Telegram](#Telegram)
- [Видео примеры прохождения тестов](#Video)
- [Видео прохождения мобильного теста](#VideoMobile)

<h1 align="left">
<a name="Technology"><i>Технологии и инструменты</i></a>
</h1>

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="images/logo/AllureTestOps.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://appium.io/"><img src="images/logo/appium.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://rest-assured.io/"><img src="images/logo/Rest-Assured.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://developer.android.com/studio"><img src="images/logo/androidstudio.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.browserstack.com/"><img src="images/logo/Browserstack.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

<h1 align="left">
<a name="Checks"><i>Реализованные проверки</i></a>
</h1>

- Набор разнообразных UI тестов
- Несколько API тестов
- Тесты на мобильное приложение "Открытие Обучение"

## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a><a name="Jenkins"> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/013_Putintsev_14_Jenkins_Telegram/"> job </a></a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/013_Putintsev_14_Jenkins_Telegram/"><img src="images/Jenkins.PNG" alt="Jenkins"/></a>
</p>

### Параметры сборки в Jenkins:
- tag (Вид тестов WEB,API,Mobile) - обязательный параметр
- Host (Удаленно или локально) - обязательный параметр
- browser (браузер, по умолчанию chrome)
- version (версия браузера, по умолчанию 99.0)
- size (размер окна браузера, по умолчанию 1920x1080)

## <a name="RemoteLaunch">Запуск тестов из терминала</a>

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
## <img src="images/logo/AllureTestOps.png" width="25" height="25"  alt="Allure"/></a><a name="AllureTestOps"> Отчет в <a target="_blank" href="https://allure.autotests.cloud/project/1538/dashboards">Allure TestOps</a></a>

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

### Тест с использованием API

<p align="center">
<img title="Allure Overview Dashboard" src="images/Api.PNG">
</p>

### Спсисок ошибок

<p align="center">
<img title="Allure Overview Dashboard" src="images/Список ошибок.PNG">
</p>

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a><a name="Allure"> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/013_Putintsev_14_Jenkins_Telegram/23/allure/">Allure report</a></a>

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

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a><a name="Telegram"> Уведомление в Telegram при помощи бота</a>

<p align="center">
<img title="Allure Overview Dashboard" src="images/Telegram.PNG" >
</p>


## <img src="images/logo/Selenoid.svg" width="25" height="25"  alt="Allure"/></a><a name="Video"> Видео прохождения теста</a>

<p align="center">
<img title="Selenoid Video" src="images/3a411e3c8853f2fb.gif" width="250" height="153"  alt="video">
<img title="Selenoid Video" src="images/b8d6d3f36c113950.gif" width="250" height="153"  alt="video"> 
<img title="Selenoid Video" src="images/cdbb275e1308bf2.gif" width="250" height="153"  alt="video"> 
</p>

## <img src="images/logo/Browserstack.svg" width="25" height="25"  alt="Allure"/></a><a name="VideoMobile"> Видео прохождения мобильного теста</a>

<p align="center">
<img title="Selenoid Video" src="images/browserstack.gif" alt="video">
</p>