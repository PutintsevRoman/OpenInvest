package pages.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    public SelenideElement catalog = $("[data-tracker-id=l1n0ZEHMx9]");

    @Step("Переходим с главной страницы на страницу Каталог")
    public void openCatalogPage() {
        catalog.click();
    }

    @Step("Проверка, что открыта страница Каталога")
    public void checkCatalogPage(String txt) {
        $("h1").shouldHave(text(txt));
    }

    @Step("Открытие страницы с акциями")
    public void openStocks() {
        $(byText("Акции")).click();
    }

    @Step("Открытие страницы с облигациями")
    public void openBonds() {
        $(byText("Облигации")).click();
    }

    @Step("Открытие страницы с готовыми продуктами")
    public void openSolutions() {
        $(byText("Готовые решения")).click();
    }

    @Step("Поиск по бумаге (Акции/Облигации)")
    public void searchPaper(String name) {
        $(".PureInput_input__type-search__A3GDo").setValue(name).pressEnter();
    }

    @Step("Проверка резульаттов поиска")
    public void checkSearchPaper(String name) {
        $$(".InstrumentTableItem_name__k5SGH").findBy(text(name)).shouldBe(visible);
    }

    @Step("Проверка списка предложений по стратегии ИИС")
    public void checkSolutions(String [] names) {
        $$(".InstrumentCard_info__guD5z").shouldHave(texts(names));
    }

    @Step("открыть страницу с стратегиями ИИС")
    public void openStrategy() {
        $(byText("Стратегии ИИС")).click();
    }
}
