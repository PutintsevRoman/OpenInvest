package test;

import MainPage.Main;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MainPageTests extends TestBase{

    Main main = new Main();

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Тарифами")
    @Owner("Путинцев, Роман")
    @Severity(SeverityLevel.MINOR)
    void TestHeaderLinksTariff() {
        main.OpenMainPage();
        main.OpenTariffPage();
        main.CheckTariffPage();
    }

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Каталогом")
    @Owner("Путинцев, Роман")
    @Severity(SeverityLevel.MINOR)
    void TestHeaderLinksCatalog() {
        main.OpenMainPage();
        main.OpenCatalogPage();
        main.CheckCatalogPage();
    }

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Аналитикой")
    @Owner("Путинцев, Роман")
    @Severity(SeverityLevel.MINOR)
    void TestHeaderLinksAnalys() {
        main.OpenMainPage();
        main.OpenAnalysPage();
        main.CheckAnalysPage();
    }

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Обучением")
    @Owner("Путинцев, Роман")
    @Severity(SeverityLevel.MINOR)
    void TestHeaderLinksStudy() {
        main.OpenMainPage();
        main.OpenStudyPage();
        main.CheckStudyPage();
    }
}
