package test.mobile;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.mobile.AuthorisationPage;
import test.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Owner("Путинцев, Роман")
@Feature("Тесты на Странице с обучением")
@Epic("Mobile тесты")
@Tag("Mobile")
public class AuthorisationPageMobileTests extends TestBase {
    AuthorisationPage authorisationPage = new AuthorisationPage();

    @Test
    @DisplayName("Тест на проверку всплывающего сообщения о незаполнености поля")
    @Severity(SeverityLevel.MINOR)
    void emptyTelNumTest() {
        authorisationPage.signInButton();
        authorisationPage.authorisationButtonClick();
        authorisationPage.emptyButtonCheck();
    }

    @Test
    @DisplayName("Тест на проверку всплывающего сообщения об отсуствии согласия на обработку персональных данных")
    @Severity(SeverityLevel.MINOR)
    void emptyCommunicationCheckBoxTest() {
        authorisationPage.signInButton();
        authorisationPage.setTelNum();
        authorisationPage.communicationCheckBoxClick();
        authorisationPage.authorisationButtonClick();
        authorisationPage.bigMessagesCheck();
    }
}
