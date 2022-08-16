package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CatalogPage;
import pages.MainPage;

@Owner("Путинцев, Роман")
@Feature("Issues")
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
}
