package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

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
}
