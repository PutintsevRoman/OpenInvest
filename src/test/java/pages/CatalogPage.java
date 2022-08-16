package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    public SelenideElement catalog = $("[data-tracker-id=l1n0ZEHMx9]");

    @Step("Переходим с главной страницы на страницу Каталог")
    public void openCatalogPage() {
        catalog.click();
    }

    @Step("Проверяем, что мы находимся, на нужной странице")
    public void checkCatalogPage() {
        $("h1").shouldHave(Condition.text("С ЧЕГО НАЧАТЬ В АВГУСТЕ"));
    }
}
