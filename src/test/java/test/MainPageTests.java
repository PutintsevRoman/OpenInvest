package test;

import com.codeborne.pdftest.PDF;
import io.qameta.allure.Feature;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;


@Owner("Путинцев, Роман")
@Feature("Issues")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    AnalysPage analysPage = new AnalysPage();
    CatalogPage catalogPage = new CatalogPage();
    TariffPage tariffPage = new TariffPage();
    StudyPage studyPage = new StudyPage();

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Тарифами")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksTariff() {
        mainPage.openMainPage();
        tariffPage.openTariffPage();
        tariffPage.checkTariffPage();
    }

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Каталогом")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksCatalog() {
        mainPage.openMainPage();
        catalogPage.openCatalogPage();
        catalogPage.checkCatalogPage();
    }

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Аналитикой")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksAnalys() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.checkAnalysPage();
    }

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Обучением")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksStudy() {
        mainPage.openMainPage();
        studyPage.openStudyPage();
        studyPage.checkStudyPage();
    }

    @Test
    @DisplayName("Тест на проверку документации Согласия на коммуникацию")
    @Severity(SeverityLevel.NORMAL)
    void testFilesContains() throws Exception {
        mainPage.openMainPage();
        mainPage.openRegistrationForm();
        PDF pdf = mainPage.downloadComunicationFile();
        assertThat(pdf.text).contains("СОГЛАСИЕ НА КОММУНИКАЦИЮ");
    }

    @Test
    @DisplayName("Тест на проверку документации на обработку персональных данных")
    @Severity(SeverityLevel.NORMAL)
    void testFilesPersonal() throws Exception {
        mainPage.openMainPage();
        mainPage.openRegistrationForm();
        PDF pdf = mainPage.downloadPersonalFile();
        assertThat(pdf.text).contains("СОГЛАСИЕ");
        assertThat(pdf.text).contains("на обработку персональных данных");
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
}
