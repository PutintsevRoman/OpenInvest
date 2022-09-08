package pages.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TariffPage {
    public SelenideElement tariff = $("[data-tracker-id=q3sP6mq3B7]");

    @Step("Переходим с главной страницы на страницу Тарифов")
    public void openTariffPage() {
        tariff.click();
    }

    @Step("Проверка что открыта страница Тарифов")
    public void checkTariffPage() {
        $("h1").shouldHave(text("Тарифы"));
    }

    @Step("Проверка что тарифов 4")
    public void checkTariffLists() {
        $$(".TariffCard_cardWrapper__yIStY").shouldHave(size(4));
        $$(".TariffCard_cardWrapper__yIStY").shouldHave(texts("Всё включено",
                "Инвестиционный",
                "Премиальный",
                "Спекулятивный"));
    }

    @Step("Проверка содержимого тарифа")
    public void checkTariffContent(String testData) {
        String id = null;
        switch (testData) {
            case "Всё включено":
                id = "#all-inclusive";
                break;
            case "Инвестиционный":
                id = "#investment";
                break;
            case "Премиальный":
                id = "#premium";
                break;
            case "Спекулятивный":
                id = "#speculative";
                break;
        }

        assert id != null;

        $(id).shouldBe(visible);
        $(id).$(".Button_btn__iconWrapper__U3QZf").click();
        $(id).$(".Details_content__lY3Do").shouldBe(visible);

    }
}

