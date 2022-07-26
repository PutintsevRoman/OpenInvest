package MainPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Main {

    public SelenideElement mainLogo = $("#Logo_titleWrapper__1sWUV"),
            tariff = $("[data-tracker-id=q3sP6mq3B7]"),
            catalog = $("[data-tracker-id=l1n0ZEHMx9]"),
            analys = $("[data-tracker-id=0HwcTEJyrq]"),
            study = $("[data-tracker-id=HFDmhXuknX]");

    @Step("Открываем главную страницу")
    public void OpenMainPage() {
        open("https://open-broker.ru/invest/");
    }

    @Step("Переходим с главной страницы на страницу Тарифов")
    public void OpenTariffPage() {
        tariff.click();
    }
    @Step("Переходим с главной страницы на страницу Каталог")
    public void OpenCatalogPage() {
        catalog.click();
    }
    @Step("Переходим с главной страницы на страницу Аналитика")
    public void OpenAnalysPage() {
        //analys.find(text);
        $(withText("Аналитика")).click();

    }
    @Step("Переходим с главной страницы на страницу Обучение")
    public void OpenStudyPage() {
        study.click();
    }
    @Step("Проверяем, что мы находимся, на нужной странице")
    public void CheckTariffPage() {
        $("h1").shouldHave(Condition.text("Тарифы"));
    }
    @Step("Проверяем, что мы находимся, на нужной странице")
    public void CheckCatalogPage() {
        $("h1").shouldHave(Condition.text("С ЧЕГО НАЧАТЬ В ИЮЛЕ"));
    }
    @Step("Проверяем, что мы находимся, на нужной странице")
    public void CheckAnalysPage() {
        $("button.Tabs-module__tabs__button--active--2iabF").shouldHave(Condition.text("Эфир"));
    }
    @Step("Проверяем, что мы находимся, на нужной странице")
    public void CheckStudyPage() {
        $("h1").shouldHave(Condition.text("ДЛЯ НАЧИНАЮЩЕГО ИНВЕСТОРА"));
    }
}
