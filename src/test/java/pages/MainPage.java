package pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {

    public SelenideElement mainLogo = $("#Logo_titleWrapper__1sWUV"),
            FirstNameConsultationForm = $("[name=firstName]"),
            LastNameConsultationForm = $("[name=lastName]"),
            TelNumConsultationForm = $("[name=phone]");

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://open-broker.ru/invest/");
    }

    @Step("Открываем страницу создания счета")
    public void openRegistrationForm() {
        $(withText("Открыть счёт")).click();
    }

    @Step("Загружаем согласие на Коммуникацию")
    public PDF downloadComunicationFile() throws Exception {
        File file = $(
                "a[href*='https://s3.open-broker.ru/site/disclosure/communication_agreement.pdf?open=true']")
                .download();
        PDF pdf = new PDF(file);
        return pdf;
    }

    @Step("Загружаем согласие на Обработку персональных данных")
    public PDF downloadPersonalFile() throws Exception {
        File file = $(
                "a[href*='https://s3.open-broker.ru/site/disclosure/personal_agreement.pdf?open=true']")
                .download();
        PDF pdf = new PDF(file);
        return pdf;
    }

    @Step("Проверка документа -Согласие на коммуникацию")
    public void checkCommunicationFile(PDF file) {
        assertThat(file.text).contains("СОГЛАСИЕ НА КОММУНИКАЦИЮ");
    }

    @Step("Проверка документа -Согласие на обработку персональных данных")
    public void checkPersonalFile(PDF file) {
        assertThat(file.text).contains("СОГЛАСИЕ");
        assertThat(file.text).contains("на обработку персональных данных");
    }

    @Step("Устанавливаем значение Имени в поле")
    public void setFirstNameConsultationForm(String value) {
        FirstNameConsultationForm.setValue(value);
    }

    @Step("Устанавливаем значение Фамилии в поле")
    public void setLastNameConsultationForm(String value) {
        LastNameConsultationForm.setValue(value);
    }

    @Step("Устанавливаем значение Телефонного номера в поле")
    public void setTelNumConsultationForm(String value) {
        TelNumConsultationForm.setValue(value);
    }

    @Step("Нажимаем кнопку Отправить")
    public void submitConsultationForm() {
        $(withText("Отправить")).click();
    }

    @Step("Проверка правильности полученных данных")
    public void checkNegativeConsultationForm(Boolean FristName, Boolean LastName, Boolean TelNum) {
        if (FristName) $(withText("Имя")).parent()
                .$("[class =SimpleTooltip_simple-tooltip__container__JAfyH]").shouldBe(Condition.visible);

        if (LastName) $(withText("Фамилия")).parent()
                .$("[class =SimpleTooltip_simple-tooltip__container__JAfyH]").shouldBe(Condition.visible);
        if (TelNum) $(withText("Телефон")).parent()
                .$("[class =SimpleTooltip_simple-tooltip__container__JAfyH]").shouldBe(Condition.visible);
    }

    @Step("Открытие доп меню")
    public void openMenu() {
        $(".Button_btn__iconWrapper__TQKQe").click();
    }

    @Step("Открытие страницы с Оффисами")
    public void openOfficePage() {
        $(byText("Офисы")).click();
    }

    @Step("Проверка страницы с Оффисами")
    public void checkOfficePage() {
        $$(".region").first().shouldHave(Condition.text("Абакан"));
    }
}
