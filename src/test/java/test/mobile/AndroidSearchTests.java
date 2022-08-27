package test.mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Owner("Путинцев, Роман")
@Feature("Тесты на Странице с обучением")
@Epic("API тесты")
@Tag("Mobile")
public class AndroidSearchTests extends TestBase {
    @Test
    void searchTest() {
        step("Saved Bar check ", () -> {
            $(AppiumBy.id("ru.opentrainer.app:id/bt_welcome_sign_in")).click();
            $(AppiumBy.id("ru.opentrainer.app:id/bt_button_big_with_progress")).click();
            $(AppiumBy.id("ru.opentrainer.app:id/textinput_error")).shouldHave(Condition.text("Введите номер телефона"));
        });

    }

    @Test
    void bababa() {
        step("Saved Bar check ", () -> {
            $(AppiumBy.id("ru.opentrainer.app:id/bt_welcome_sign_in")).click();
            $(AppiumBy.id("ru.opentrainer.app:id/tiet_phone_input")).sendKeys("+7 (905) 202 73 43");
            $(AppiumBy.id("ru.opentrainer.app:id/cb_phone_input_privacy_agreement")).click();
            $(AppiumBy.id("ru.opentrainer.app:id/bt_button_big_with_progress")).click();
            $(AppiumBy.id("ru.opentrainer.app:id/tv_event_notification")).shouldHave(Condition.text("Необходимо согласие на обработку персональных данных"));
        });
    }
}
/*  step("Search Bar check ", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_search")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/history_title")).shouldHave(Condition.text("History"));
        });
        step("Edit Tab check ", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_edits")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/messageTitleView"))
                    .shouldHave(Condition.text("Did you know that everyone can edit Wikipedia?"));
        });
        step("Explore Tab check ", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_explore")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(Condition.text("Customize your Explore feed You can now choose what to show on your feed, and also prioritize your favorite types of content."));
        });*/