package config;


import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebDriverProvider {
    WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    public void configure() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browser = String.valueOf(webDriverConfig.getBrowser());
        Configuration.browserSize = webDriverConfig.getBrowserSize();
        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();

        if (webDriverConfig.remote()) {
            String remoteDriverUrl = System.getProperty("remoteDriverUrl", "selenoid.autotests.cloud/wd/hub");
            Configuration.remote = String.format("https://%s:%s@%s", config.login(), config.password(), remoteDriverUrl);
        }
        Configuration.browserCapabilities = capabilities;
    }
}
