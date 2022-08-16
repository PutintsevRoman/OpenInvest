package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.StudyPage;

@Owner("Путинцев, Роман")
@Feature("Issues")
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
}
