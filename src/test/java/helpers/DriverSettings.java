package helpers;

import com.codeborne.selenide.Configuration;
import config.CredentialsConfig;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverSettings {
    private static final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configure() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browser = String.valueOf(webDriverConfig.getBrowser());
        Configuration.browserSize = webDriverConfig.getBrowserSize();
        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();

        if (webDriverConfig.remote()) {
            Configuration.remote = webDriverConfig.getRemoteUrl();
        }


        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        String remoteDriverUrl = System.getProperty("remoteDriverUrl", "selenoid.autotests.cloud/wd/hub");
        Configuration.remote = String.format("https://%s:%s@%s", config.login(), config.password(), remoteDriverUrl);

        Configuration.browserCapabilities = capabilities;
    }
}
