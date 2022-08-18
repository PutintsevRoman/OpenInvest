package test;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;



@Owner("Путинцев, Роман")
@Feature("Тесты на Основной странице")
@Epic("UI тесты")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Тест на проверку документации Согласия на коммуникацию")
    @Severity(SeverityLevel.NORMAL)
    void testFilesContains() throws Exception {
        mainPage.openMainPage();
        mainPage.openRegistrationForm();
        mainPage.checkCommunicationFile( mainPage.downloadComunicationFile());
    }

    @Test
    @DisplayName("Тест на проверку документации на обработку персональных данных")
    @Severity(SeverityLevel.NORMAL)
    void testFilesPersonal() throws Exception {
        mainPage.openMainPage();
        mainPage.openRegistrationForm();
        mainPage.checkPersonalFile( mainPage.downloadPersonalFile());
    }

    @DisplayName("Несколько негативных тестов на форму для получения консультации")
    @Severity(SeverityLevel.NORMAL)
    @CsvFileSource(resources = "consultationNegative.csv")
    @ParameterizedTest()
    void testConsultationFormNegative(String LastName, String FirstName, String TelNum, Boolean LtName, Boolean FrName, Boolean TNum) {
        mainPage.openMainPage();
        mainPage.setLastNameConsultationForm(LastName);
        mainPage.setFirstNameConsultationForm(FirstName);
        mainPage.setTelNumConsultationForm(TelNum);
        mainPage.submitConsultationForm();
        mainPage.checkNegativeConsultationForm(FrName, LtName, TNum);
    }

    @Test
    @DisplayName("Тест на проверку страницы с Оффисами")
    @Severity(SeverityLevel.MINOR)
    void testOfficesPage(){
        mainPage.openMainPage();
        mainPage.openMenu();
        mainPage.openOfficePage();
        mainPage.checkOfficePage();
    }
}
