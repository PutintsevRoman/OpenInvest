package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AnalysPage;
import pages.MainPage;

@Owner("Путинцев, Роман")
@Feature("Issues")
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
    void testNewsCalendar() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.openCalendar();
        analysPage.setValue("август 2022", "1", "3");
        analysPage.submitCalendar();
        analysPage.checkDateNews("август", "3");
    }

    @Test
    void testDividentPaper() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.openDividentCalendar();
        analysPage.clickOnDividents();
        analysPage.checkFirstPaper("Банк Санкт-Петербург");
    }

    @Test
    void testDividentPaperSearch() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.openDividentCalendar();
        analysPage.searchPaper("Mori");
        analysPage.checkFirstPaper("Mori");
    }

    @Test
    void testNewsSearch() {
        mainPage.openMainPage();
        analysPage.openAnalysPage();
        analysPage.openDividentNews();
        analysPage.searchNews("ВТБ");
        analysPage.checkNews("ВТБ");
    }
}
