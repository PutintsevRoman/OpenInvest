package test.api;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.qameta.allure.*;
import models.AuthorisationResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import api.EducationApi;
import pages.ui.MainPage;
import pages.ui.StudyPage;
import test.TestBase;
import test.TestData;

import java.io.IOException;


@Owner("Путинцев, Роман")
@Feature("Тесты на Странице с обучением")
@Epic("API тесты")
@Tag("API")
public class EducationApiTests extends TestBase {
    EducationApi educationApiPage = new EducationApi();
    MainPage mainPage = new MainPage();
    TestData testData = new TestData();
    StudyPage studyPage = new StudyPage();

    String cookieName = "api/cookie.json";
    String bodyJson = "api/body.json";

    @Test
    @DisplayName("Тест на авторизацию")
    @Severity(SeverityLevel.NORMAL)
    public void authorisationApiTest() throws IOException {
        AuthorisationResponseModel authorisationResponseModel = new AuthorisationResponseModel();

        JsonNode jsonNode = educationApiPage.parseJson(cookieName);
        authorisationResponseModel.setCookies(educationApiPage.authorisationApi(jsonNode));
        mainPage.openMainPage();
        educationApiPage.setCookies(authorisationResponseModel.getCookies());
        studyPage.openStudyPage();
        studyPage.checkAuthorisation();
    }

    @Test
    @DisplayName("Тест на изменение Имени пользователя через UI с авторизацией с API")
    @Severity(SeverityLevel.NORMAL)
    public void changeCustomerDataTestUI() throws IOException {
        AuthorisationResponseModel authorisationResponseModel = new AuthorisationResponseModel();
        JsonNode jsonNode = educationApiPage.parseJson(bodyJson);

        authorisationResponseModel.setCookies(educationApiPage.authorisationApi(jsonNode));

        mainPage.openMainPage();
        educationApiPage.setCookies(authorisationResponseModel.getCookies());
        studyPage.openStudyPage();
        studyPage.openCustomerRedactor();
        studyPage.changeCustomerName(testData.getName());
        studyPage.clickSubmit();
        studyPage.checkRename();

    }

    @Test
    @DisplayName("Тест на изменение Имени пользователя через API с авторизацией с API")
    @Severity(SeverityLevel.NORMAL)
    public void changeCustomerDataTestApi() throws IOException {

        ObjectNode jsonNodeBody = (ObjectNode) educationApiPage.parseJson(bodyJson);
        AuthorisationResponseModel authorisationResponseModel = new AuthorisationResponseModel();
        String name = testData.getName();

        JsonNode jsonNode = educationApiPage.parseJson(cookieName);
        authorisationResponseModel.setCookies(educationApiPage.authorisationApi(jsonNode));

        educationApiPage.changeToken(authorisationResponseModel, jsonNodeBody);
        educationApiPage.changeName(name, jsonNodeBody);
        educationApiPage.customerNameApi(authorisationResponseModel, jsonNodeBody);
        mainPage.openMainPage();
        educationApiPage.setCookies(authorisationResponseModel.getCookies());
        studyPage.openStudyPage();
        studyPage.openCustomerRedactor();
        studyPage.checkName(name);
    }
}



