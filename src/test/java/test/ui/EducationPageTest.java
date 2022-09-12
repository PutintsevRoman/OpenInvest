package test.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ui.MainPage;
import pages.ui.EducationPage;
import test.TestBase;

@Owner("Путинцев, Роман")
@Feature("Тесты на странице с Обучением")
@Epic("UI тесты")
@Tag("WEB")
@Tag("ALL")
public class EducationPageTest extends TestBase {
    MainPage mainPage = new MainPage();
    EducationPage educationPage = new EducationPage();

    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Обучением")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksStudy() {
        mainPage.openMainPage();
        educationPage.openStudyPage();
        educationPage.checkStudyPage("ДЛЯ НАЧИНАЮЩЕГО ИНВЕСТОРА");
    }

    @Test
    @DisplayName("Тест на проверку работы рекомендаций курсов")
    @Severity(SeverityLevel.NORMAL)
    void testPersonalOffers() {
        String skills[] ={"Инвестирование","Акции","Фонды","Рынок России"};
        mainPage.openMainPage();
        educationPage.openStudyPage();
        educationPage.choosePersonalLevel("Начинающий");
        educationPage.choosePersonalSkills(skills);
        educationPage.getRecommendations();
        educationPage.checkRecommendations("Как выбрать и получить вычеты по ИИС");
    }

    @Test
    @DisplayName("Тест на проверку количества платных курсов")
    @Severity(SeverityLevel.NORMAL)
    void testMoneyCourses() {
        mainPage.openMainPage();
        educationPage.openStudyPage();
        educationPage.getAllCourses();
        educationPage.clickFiletCourses();
        educationPage.chooseMoneyCourses();
        educationPage.checkFirstMoneyCourses();
    }
}
