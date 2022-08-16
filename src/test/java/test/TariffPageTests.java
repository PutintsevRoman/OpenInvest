package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.TariffPage;

@Owner("Путинцев, Роман")
@Feature("Issues")
public class TariffPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    TariffPage tariffPage = new TariffPage();

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Тарифами")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksTariff() {
        mainPage.openMainPage();
        tariffPage.openTariffPage();
        tariffPage.checkTariffPage();
    }

    @Test
    @DisplayName("Проверка количества тарифов")
    @Severity(SeverityLevel.MINOR)
    void testTariffLists() {
        mainPage.openMainPage();
        tariffPage.openTariffPage();
        tariffPage.checkTariffLists();
    }


    @DisplayName("Проверка количества тарифов")
    @Severity(SeverityLevel.MINOR)
    @ValueSource(strings = {
            "Всё включено",
            "Инвестиционный",
            "Премиальный",
            "Спекулятивный"
    })
    @ParameterizedTest()
    void testTariffContent(String testData) {
        mainPage.openMainPage();
        tariffPage.openTariffPage();
        tariffPage.checkTariffContent(testData);
    }


}
