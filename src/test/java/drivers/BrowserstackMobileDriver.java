package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static final BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user",config.username());
        mutableCapabilities.setCapability("browserstack.key", config.password());
        mutableCapabilities.setCapability("app", "bs://"+ config.app());
        mutableCapabilities.setCapability("device",config.device());
        mutableCapabilities.setCapability("os_version", config.os_version());
        mutableCapabilities.setCapability("project", "OpenInvest");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "MobileTests");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.URL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
