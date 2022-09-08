package api;

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

import static io.restassured.RestAssured.given;
import static java.nio.charset.StandardCharsets.UTF_8;
import static specs.RegistrationSpecs.requestSpecificationRequest;
import static specs.RegistrationSpecs.requestSpecificationResponse;

public class EducationApi {
    ClassLoader classLoader = EducationApi.class.getClassLoader();
    String accessToken = "access_token",
            expiresIn = "expires_in",
            refreshToken = "refresh_token",
            refreshTokenExpiresIn = "refresh_token_expires_in",
            userId = "user_id";

    @Step("Создание объекта JSON из файла")
    public JsonNode parseJson(String Name) throws IOException {
        InputStream is = classLoader.getResourceAsStream(Name);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(new InputStreamReader(is, UTF_8));
    }

    @Step("API запрос на авторизацию, сохраняются полученные Cookie")
    public Cookies authorisationApi(JsonNode jsonNode) {
        Cookie accessTokenCookie = new Cookie.Builder(accessToken,
                jsonNode.get(accessToken).asText()).build();
        Cookie expiresInCookie = new Cookie.Builder(expiresIn,
                jsonNode.get(expiresIn).asText()).build();
        Cookie refreshTokenCookie = new Cookie.Builder(refreshToken,
                jsonNode.get(refreshToken).asText()).build();
        Cookie refreshTokenExpiresInCookie = new Cookie.Builder(refreshTokenExpiresIn,
                jsonNode.get(refreshTokenExpiresIn).asText()).build();
        Cookie userIdCookie = new Cookie.Builder(userId,
                jsonNode.get(userId).asText()).build();

        return given()
                .spec(requestSpecificationRequest)
                .cookie(accessTokenCookie)
                .cookie(expiresInCookie)
                .cookie(refreshTokenCookie)
                .cookie(refreshTokenExpiresInCookie)
                .cookie(userIdCookie)
                .when()
                .get("education/")
                .then()
                .spec(requestSpecificationResponse)
                .extract()
                .detailedCookies();
    }

    @Step("Добавление сохраненых Cookie в браузер")
    public void setCookies(Cookies cookies) {
        for (Cookie cookie : cookies) {
            org.openqa.selenium.Cookie cookie1;
            cookie1 = new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
            WebDriverRunner.getWebDriver().manage().addCookie(cookie1);
        }
    }

    public String getCookiesByName(String name, Cookies cookies){
        return cookies.getValue(name);
    }

    @Step("Редактирование объекта JSON с изменением токена авторизации на полученный ранее")
    public void changeToken(AuthorisationResponseModel authorisationResponseModel, ObjectNode jsonNodeBody) {
        String cookie = getCookiesByName(accessToken,authorisationResponseModel.getCookies());
        JsonNode newNode = new TextNode(String.format("Bearer %s", cookie));
        ObjectNode jsonNode1 = (ObjectNode) jsonNodeBody.get("config").get("headers");
        jsonNode1.replace("Authorization", newNode);
    }

    @Step("Редактирование объекта JSON с изменением имени пользователя")
    public void changeName(String name, ObjectNode jsonNodeBody) {
        JsonNode newNode = new TextNode(String.format(name));
        ObjectNode jsonNode1 = (ObjectNode) jsonNodeBody.get("payload");
        jsonNode1.replace("fname", newNode);
    }

    @Step("API запрос на изменение Имени пользователя")
    public void customerNameApi(AuthorisationResponseModel authorisationResponseModel, ObjectNode jsonNodeBody) {
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
