package pages.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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

    @Step("Выбор нужного уровеня знаний")
    public void choosePersonalLevel(String level) {
        $$(".LevelCard_wrapper__18zc-").findBy(Condition.text(level)).click();
    }

    @Step("Выбор нужных тем")
    public void choosePersonalSkills(String level[]) {
        if (level.length == 4)
            for (String s : level)
                $$(".QuizAnswer_wrapper__2E6py").findBy(Condition.text(s)).click();
    }

    @Step("Получение рекомендаций")
    public void getRecommendations() {
        $(byText("Получить рекомендации")).click();
    }

    @Step("Проверка рекомендаций")
    public void checkRecommendations() {
        $$(".ContentCardTemplate_contentWrapper__jXIUQ").first().shouldHave(Condition.text("Как выбрать и получить вычеты по ИИС"));
    }

    @Step("Переход на страницу с курсами")
    public void getAllCourses() {
        $(byText("Все видеокурсы")).click();
    }

    @Step("Открываем фильтр")
    public void clickFiletCourses() {
        $(byText("Платные и бесплатные")).click();
    }

    @Step("Выбор платных курсов")
    public void chooseMoneyCourses() {
        $$(".DropdownRow_content__2VdTx").find(Condition.exactText("Платные")).click();
    }

    @Step("Проверка количества платных курсов")
    public void checkFirstMoneyCourses() {
        $$(".ContentCardTemplate_contentWrapper__jXIUQ").shouldHave(CollectionCondition.size(2));
    }

}
