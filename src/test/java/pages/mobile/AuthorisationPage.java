package pages.mobile;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthorisationPage {

    @Step("Нажимаем на кнопку для перехода к форме авторизации")
    public void signInButton() {
        $(AppiumBy.id("ru.opentrainer.app:id/bt_welcome_sign_in")).click();
    }

    @Step("Нажимаем на кнопку для подтверждения авторизации")
    public void authorisationButtonClick() {
        $(AppiumBy.id("ru.opentrainer.app:id/bt_button_big_with_progress")).click();
    }

    @Step("Проверка всплывающего поля с ошибкой о незаполненом поле")
    public void emptyButtonCheck(String txt) {
        $(AppiumBy.id("ru.opentrainer.app:id/textinput_error")).shouldHave(text(txt));
    }

    @Step("Заполнение поля с номером телефона")
    public void setTelNum(String telNum) {
        $(AppiumBy.id("ru.opentrainer.app:id/tiet_phone_input")).sendKeys(telNum);
    }

    @Step("Установка/снятие чекбокса с согласием на обработку персональных данных")
    public void communicationCheckBoxClick() {
        $(AppiumBy.id("ru.opentrainer.app:id/cb_phone_input_privacy_agreement")).click();
    }

    @Step("Проверка большого всплывающего сообщения")
    public void bigMessagesCheck(String txt) {
        $(AppiumBy.id("ru.opentrainer.app:id/tv_event_notification")).shouldHave(text(txt));
    }
}
