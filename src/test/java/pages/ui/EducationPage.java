package pages.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EducationPage {
    public SelenideElement study = $("[data-tracker-id=HFDmhXuknX]");

    @Step("Переходим с главной страницы на страницу Обучение")
    public void openStudyPage() {
        study.click();
    }

    @Step("Проверяем, что мы находимся, на нужной странице")
    public void checkStudyPage() {
        $("h1").shouldHave(text("ДЛЯ НАЧИНАЮЩЕГО ИНВЕСТОРА"));
    }

    @Step("Выбор нужного уровеня знаний")
    public void choosePersonalLevel(String level) {
        $$(".LevelCard_wrapper__18zc-").findBy(text(level)).click();
    }

    @Step("Выбор нужных тем")
    public void choosePersonalSkills(String level[]) {
        if (level.length == 4)
            for (String s : level)
                $$(".QuizAnswer_wrapper__2E6py").findBy(text(s)).click();
    }

    @Step("Получение рекомендаций")
    public void getRecommendations() {
        $(byText("Получить рекомендации")).click();
    }

    @Step("Проверка рекомендаций")
    public void checkRecommendations() {
        $$(".ContentCardTemplate_contentWrapper__jXIUQ").first().shouldHave(text("Как выбрать и получить вычеты по ИИС"));
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
        $$(".DropdownRow_content__2VdTx").find(exactText("Платные")).click();
    }

    @Step("Проверка количества платных курсов")
    public void checkFirstMoneyCourses() {
        $$(".ContentCardTemplate_contentWrapper__jXIUQ").shouldHave(CollectionCondition.size(2));
    }

    @Step("Проверка того, что страница открыта с авторизованным пользователем")
    public void checkAuthorisation() {
        $(byText("Профиль")).shouldBe(visible);
    }

    @Step("Переход на страницу редактирования данных пользователя")
    public void openCustomerRedactor() {
        $(byText("Профиль")).click();
    }

    @Step("Изменение имени пользователя через UI")
    public void changeCustomerName(String name) {
        $$(".PureInput_input__input__2RhRG").first().setValue(name);
    }

    @Step("Сохранение данных")
    public void clickSubmit() {
        $(byText("Сохранить")).click();
    }

    @Step("Проверка всплывающего сообщения о том, что данные сохранены")
    public void checkRename() {
        $(byText("Данные успешно сохранены")).shouldBe(visible);
    }

    @Step("Проверка того, что у пользователя новое Имя")
    public void checkName(String name) {
        $$(".PureInput_input__input__2RhRG").first().shouldHave(value(name));
    }
}
