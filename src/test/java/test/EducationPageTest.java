package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.StudyPage;

@Owner("Путинцев, Роман")
@Feature("Тесты на странице с Обучением")
@Epic("UI тесты")
public class EducationPageTest extends TestBase{

    MainPage mainPage = new MainPage();
    StudyPage studyPage = new StudyPage();


    @Test
    @DisplayName("Простой тест на проверку ссылки на страницу с Обучением")
    @Severity(SeverityLevel.MINOR)
    void testHeaderLinksStudy() {
        mainPage.openMainPage();
        studyPage.openStudyPage();
        studyPage.checkStudyPage();
    }

    @Test
    @DisplayName("Тест на проверку работы рекомендаций курсов")
    @Severity(SeverityLevel.NORMAL)
    void testPersonalOffers() {
        String skills[] ={"Инвестирование","Акции","Фонды","Рынок России"};
        mainPage.openMainPage();
        studyPage.openStudyPage();
        studyPage.choosePersonalLevel("Начинающий");
        studyPage.choosePersonalSkills(skills);
        studyPage.getRecommendations();
        studyPage.checkRecommendations();
    }
    @Test
    @DisplayName("Тест на проверку количества платных курсов")
    @Severity(SeverityLevel.NORMAL)
    void testMoneyCourses() {
        mainPage.openMainPage();
        studyPage.openStudyPage();
        studyPage.getAllCourses();
        studyPage.clickFiletCourses();
        studyPage.chooseMoneyCourses();
        studyPage.checkFirstMoneyCourses();
    }
}
