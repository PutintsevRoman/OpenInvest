package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TariffPage {

    public SelenideElement tariff = $("[data-tracker-id=q3sP6mq3B7]");

    @Step("Переходим с главной страницы на страницу Тарифов")
    public void openTariffPage() {
        tariff.click();
    }

    @Step("Проверяем, что мы находимся, на нужной странице")
    public void checkTariffPage() {
        $("h1").shouldHave(Condition.text("Тарифы"));
    }
}
