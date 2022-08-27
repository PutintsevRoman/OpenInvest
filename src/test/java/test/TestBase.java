package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import config.WebDriverProvider;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.AllureAttachments;
import helpers.DriverUtils;
import helpers.Mobile_Attach;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

import static helpers.Mobile_Attach.sessionId;
import static helpers.Mobile_Attach.video;
import static io.qameta.allure.Allure.step;


@ExtendWith({AllureJunit5.class})
public class TestBase {

    private static WebDriverProvider driver = new WebDriverProvider();
    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static String Host;

    @BeforeAll
    static void beforeAll() {
        //Host = System.getProperty("tag");
        Host="Mobile";
        if(Host.equals("Mobile")) {
            setUp();
        }else
        driver.configure();

    }
    public static void setUp(){
        if (webDriverConfig.remote()) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        }
        else {
            Configuration.browser = LocalMobileDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        if(Host.equals("Mobile")) {
            open();
        }
    }


    @AfterEach
    public void afterEach() {

        if(Host.equals("Mobile")) {
            String sessionId = sessionId();

            Mobile_Attach.screenshotAs("Last screenshot");
            Mobile_Attach.pageSource();

            step("Close driver", Selenide::closeWebDriver);

            if (webDriverConfig.remote()) video(sessionId);
        }else{

            String sessionId = DriverUtils.getSessionId();

            AllureAttachments.addScreenshotAs("Last screenshot");
            AllureAttachments.addPageSource();

            if (!Objects.equals(Configuration.browser, "FIREFOX"))
                AllureAttachments.addBrowserConsoleLogs();

            Selenide.closeWebDriver();

            AllureAttachments.addVideo(sessionId);
        }

    }
}
