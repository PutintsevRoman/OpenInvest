package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class StudyPage {

    public SelenideElement study = $("[data-tracker-id=HFDmhXuknX]");

    @Step("Переходим с главной страницы на страницу Обучение")
    public void openStudyPage() {
        study.click();
    }

    @Step("Проверяем, что мы находимся, на нужной странице")
    public void checkStudyPage() {
        $("h1").shouldHave(Condition.text("ДЛЯ НАЧИНАЮЩЕГО ИНВЕСТОРА"));
    }
}
