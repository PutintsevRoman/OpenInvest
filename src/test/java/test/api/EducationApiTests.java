package test.api;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.qameta.allure.*;
import models.AuthorisationResponseModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.api.EducationApiPages;
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
    EducationApiPages educationApiPage = new EducationApiPages();
    MainPage mainPage = new MainPage();
    TestData testData = new TestData();
    StudyPage studyPage = new StudyPage();

    @Test
    @DisplayName("Тест на авторизацию")
    @Severity(SeverityLevel.NORMAL)
    public void authorisationApiTest() throws IOException {
        AuthorisationResponseModel authorisationResponseModel = new AuthorisationResponseModel();

        JsonNode jsonNode = educationApiPage.parseJsonCookie();
        authorisationResponseModel.setCookies(educationApiPage.authorisationApi(jsonNode));
        mainPage.openMainPage();
        educationApiPage.setCookies(authorisationResponseModel.getCookies());
        studyPage.openStudyPage();
        educationApiPage.checkAuthorisation();
    }

    @Test
    @DisplayName("Тест на изменение Имени пользователя через UI с авторизацией с API")
    @Severity(SeverityLevel.NORMAL)
    public void changeCustomerDataTestUI() throws IOException {
        AuthorisationResponseModel authorisationResponseModel = new AuthorisationResponseModel();
        JsonNode jsonNode = educationApiPage.parseJsonCookie();

        authorisationResponseModel.setCookies(educationApiPage.authorisationApi(jsonNode));

        mainPage.openMainPage();
        educationApiPage.setCookies(authorisationResponseModel.getCookies());
        studyPage.openStudyPage();
        educationApiPage.openCustomerRedactor();
        educationApiPage.changeCustomerName(testData.getName());
        educationApiPage.clickSubmit();
        educationApiPage.checkRename();

    }

    @Test
    @DisplayName("Тест на изменение Имени пользователя через API с авторизацией с API")
    @Severity(SeverityLevel.NORMAL)
    public void changeCustomerDataTestApi() throws IOException {

        ObjectNode jsonNodeBody = (ObjectNode) educationApiPage.parseJsonBody();
        AuthorisationResponseModel authorisationResponseModel = new AuthorisationResponseModel();
        String name = testData.getName();

        JsonNode jsonNode = educationApiPage.parseJsonCookie();
        authorisationResponseModel.setCookies(educationApiPage.authorisationApi(jsonNode));

        educationApiPage.changeToken(authorisationResponseModel, jsonNodeBody);
        educationApiPage.changeName(name, jsonNodeBody);
        educationApiPage.customerNameApi(authorisationResponseModel, jsonNodeBody);
        mainPage.openMainPage();
        educationApiPage.setCookies(authorisationResponseModel.getCookies());
        studyPage.openStudyPage();
        educationApiPage.openCustomerRedactor();
        educationApiPage.checkName(name);
    }
}



