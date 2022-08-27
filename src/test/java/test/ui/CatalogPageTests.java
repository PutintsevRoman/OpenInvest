package test.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ui.CatalogPage;
import pages.ui.MainPage;
import test.TestBase;

@Owner("Путинцев, Роман")
@Feature("Тесты на странице Каталога")
@Epic("UI тесты")
@Tag("WEB")
@Tag("ALL")
public class CatalogPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();


    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Каталогом")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksCatalog() {
        mainPage.openMainPage();
        catalogPage.openCatalogPage();
        catalogPage.checkCatalogPage();
    }

    @Test
    @DisplayName("Тест на проверку поиска по списку акций")
    @Severity(SeverityLevel.MINOR)
    void testStocksSearch() {
        mainPage.openMainPage();
        catalogPage.openCatalogPage();
        catalogPage.openStocks();
        catalogPage.searchPaper("Сбербанк");
        catalogPage.checkSearchPaper("Сбербанк");

    }

    @Test
    @DisplayName("Тест на проверку поиска по списку облигаций")
    @Severity(SeverityLevel.MINOR)
    void testBondsSearch() {
        mainPage.openMainPage();
        catalogPage.openCatalogPage();
        catalogPage.openBonds();
        catalogPage.searchPaper("ОФЗ");
        catalogPage.checkSearchPaper("ОФЗ");

    }
    @Test
    @DisplayName("Тест на проверку списка Стратегий ИИС")
    @Severity(SeverityLevel.MINOR)
    void testSolutions() {
        mainPage.openMainPage();
        catalogPage.openCatalogPage();
        catalogPage.openSolutions();
        catalogPage.openStrategy();
        catalogPage.checkSolutions();

    }

}
