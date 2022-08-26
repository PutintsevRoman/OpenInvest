package pages.api;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import models.AuthorisationResponseModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.restassured.RestAssured.given;
import static java.nio.charset.StandardCharsets.UTF_8;
import static specs.RegistrationSpecs.requestSpecificationRequest;
import static specs.RegistrationSpecs.requestSpecificationResponse;

public class EducationApiPages {
    ClassLoader classLoader = EducationApiPages.class.getClassLoader();

    @Step("Создание объекта Cookie для авторизации")
    public JsonNode parseJsonCookie() throws IOException {
        InputStream is = classLoader.getResourceAsStream("api/cookie.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(new InputStreamReader(is, UTF_8));
    }
    @Step("Создание объекта JSON для запроса на изменение имени пользователя")
    public JsonNode parseJsonBody() throws IOException {
        InputStream is = classLoader.getResourceAsStream("api/body.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(new InputStreamReader(is, UTF_8));
    }
    @Step("API запрос на авторизацию, сохраняются полученные Cookie")
    public Cookies authorisationApi(JsonNode jsonNode){
       return given()
                .spec(requestSpecificationRequest)
                .cookie(String.valueOf(new org.openqa.selenium.Cookie("access_token",jsonNode.get("access_token").asText())))
                .cookie(String.valueOf(new org.openqa.selenium.Cookie("expires_in",jsonNode.get("expires_in").asText())))
                .cookie(String.valueOf(new org.openqa.selenium.Cookie("refresh_token",jsonNode.get("refresh_token").asText())))
                .cookie(String.valueOf(new org.openqa.selenium.Cookie("refresh_token_expires_in",jsonNode.get("refresh_token_expires_in").asText())))
                .cookie(String.valueOf(new org.openqa.selenium.Cookie("user_id",jsonNode.get("user_id").asText())))
                .when()
                .get("education/")
                .then()
                .spec(requestSpecificationResponse)
                .extract()
                .detailedCookies();
    }
    @Step("Добавление сохраненых Cookie в браузер")
    public void setCookies(Cookies cookies){
        for(Cookie cookie : cookies){
            WebDriverRunner.getWebDriver().manage().addCookie(new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue()));
        }
    }

    @Step("Проверка того, что страница открыта с авторизованным полдьзователем")
    public void checkAuthorisation(){
        $(byText("Профиль")).shouldBe(Condition.visible);
    }

    @Step("Переход на страницу редактирования данных пользователя")
    public void openCustomerRedactor(){
        $(byText("Профиль")).click();
    }

    @Step("Изменение имени пользователя через UI")
    public void changeCustomerName(String name){
        $$("[class=PureInput_input__input__2RhRG]").first().setValue(name);
    }

    @Step("Сохранение данных")
    public void clickSubmit(){
        $(byText("Сохранить")).click();
    }

    @Step("Проверка всплывающего сообщения о том, что данные сохранены")
    public void checkRename(){
        $(byText("Данные успешно сохранены")).shouldBe(Condition.visible);
    }

    @Step("Редактирование объекта JSON с изменением токена авторизации на полученный ранее")
    public void changeToken(AuthorisationResponseModel authorisationResponseModel,ObjectNode jsonNodeBody){
        JsonNode newNode = new TextNode(String.format("Bearer %s", authorisationResponseModel.getCookiesByName("access_token")));
        ObjectNode jsonNode1 = (ObjectNode) jsonNodeBody.get("config").get("headers");
        jsonNode1.replace("Authorization",newNode);
    }
    @Step("Редактирование объекта JSON с изменением имени пользователя")
    public void changeName(String name,ObjectNode jsonNodeBody){
        JsonNode newNode = new TextNode(String.format(name));
        ObjectNode jsonNode1 = (ObjectNode) jsonNodeBody.get("payload");
        jsonNode1.replace("fname",newNode);
    }
    @Step("Проверка того, что у пользователя новое Имя")
    public void checkName(String name){
        $$("[class=PureInput_input__input__2RhRG]").first().shouldHave(value(name));
    }
    @Step("API запрос на изменение Имени пользователя")
    public void customerNameApi(AuthorisationResponseModel authorisationResponseModel,ObjectNode jsonNodeBody)
    {
        given()
                .spec(requestSpecificationRequest)
                .contentType(ContentType.JSON)
                .cookies(authorisationResponseModel.getCookies())
                .header("Accept", "application/json, text/plain, *//*")
                .header("X-TS-AJAX-Request", true)
                .body(jsonNodeBody)
                .when()
                .post("https://open-broker.ru/education/api/patch/")
                .then()
                .spec(requestSpecificationResponse);
    }
}
