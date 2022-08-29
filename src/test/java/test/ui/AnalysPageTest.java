package test.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ui.AnalysPage;
import pages.ui.MainPage;
import test.TestBase;

@Owner("Путинцев, Роман")
@Feature("Тесты на странице Аналитика")
@Epic("UI тесты")
@Tag("WEB")
@Tag("ALL")
public class AnalysPageTest extends TestBase {

    MainPage mainPage = new MainPage();
    AnalysPage analysPage = new AnalysPage();


    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Аналитикой")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksAnalys() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.checkAnalysPage();
    }

    @Test
    @DisplayName("Тест на проверку выдачи новостей с периодом календаря")
    @Severity(SeverityLevel.NORMAL)
    void testNewsCalendar() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.openCalendar();
        analysPage.setValue("август 2022", "1", "3");
        analysPage.submitCalendar();
        analysPage.checkDateNews("август", "3");
    }

    @Test
    @DisplayName("Тест на проверку сортировки бумаг по Доходности")
    @Severity(SeverityLevel.MINOR)
    void testDividentPaper() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.openDividentCalendar();
        analysPage.clickOnDividents();
        analysPage.checkFirstPaper("Банк Санкт-Петербург");
    }

    @Test
    @DisplayName("Тест на проверку поиска по списку бумаг")
    @Severity(SeverityLevel.NORMAL)
    void testDividentPaperSearch() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.openDividentCalendar();
        analysPage.searchPaper("Новатэк");
        analysPage.checkFirstPaper("Новатэк");
    }

    @Test
    @DisplayName("Тест на проверку поиска по списку новостей")
    @Severity(SeverityLevel.MINOR)
    void testNewsSearch() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.openDividentNews();
        analysPage.searchNews("ВТБ");
        analysPage.checkNews("ВТБ");
    }
}
