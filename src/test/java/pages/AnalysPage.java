package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AnalysPage {

    public SelenideElement analys = $("[data-tracker-id=0HwcTEJyrq]");

    @Step("Переходим с главной страницы на страницу Аналитика")
    public void openAnalysPage() {
        //analys.find(text);
        $(withText("Аналитика")).click();

    }

    @Step("Проверяем, что мы находимся, на нужной странице")
    public void checkAnalysPage() {
        $("button.Tabs-module__tabs__button--active--2iabF").shouldHave(Condition.text("Эфир"));
    }

    @Step("Открыть календарь")
    public void openCalendar() {
        $(byText("Период")).click();
    }

    @Step("Выставить значения в календаре")
    public void setValue(String month, String firstDay, String lasDay) {
        SelenideElement selenideElement = $(byText(month)).parent();

        selenideElement.$(".Calendar-module__days--5NXCO").find(byText(firstDay)).click();
        selenideElement.$(".Calendar-module__days--5NXCO").find(byText(lasDay)).click();
    }

    @Step("Применить значения в календаре")
    public void submitCalendar() {
        $(byText("Применить")).click();
    }

    @Step("Применить значения у первой новости")
    public void checkDateNews(String month, String lasDay) {
        $$(".CardGrid_itemInfo__kde8p").first().shouldHave(Condition.text(lasDay + " " + month));
    }

    @Step("Открывть календарь дивидентов")
    public void openDividentCalendar() {
        $(byText("Календарь дивидендов")).click();
    }

    @Step("Двойное нажатие на Доходность")
    public void clickOnDividents() {
        $$(".Table_tableLabel__brFYk").get(1).doubleClick();
    }

    @Step("Проверяем первую бумагу")
    public void checkFirstPaper(String name) {
        $$(".Table_tableCell__PtnWM").first().shouldHave(Condition.text(name));
    }

    @Step("Поиск бумаги")
    public void searchPaper(String name) {
        $(".PureInput_input__type-search__A3GDo").setValue(name).pressEnter();
    }

    @Step("Поиск бумаги")
    public void searchNews(String name) {
        $(".Input-module__inner--Scvi1").setValue(name).pressEnter();
    }

    @Step("Открыть Новости депозитария")
    public void openDividentNews() {
        $(byText("Новости депозитария")).click();
    }

    @Step("Проверка новостей")
    public void checkNews(String name) {
        $(".NewsCurrent_wrapperList__r9TN5").shouldHave(Condition.text(name));
    }
}
