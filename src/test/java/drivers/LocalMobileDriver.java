package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalMobileDriver implements WebDriverProvider {

    static final MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.URL());//"http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(config.os_name());//"Android");
        options.setDeviceName(config.device());//"Pixel 4 API 30");
        options.setPlatformVersion(config.os_version());//"11.0");
        options.setApp(app.getAbsolutePath());
        //  options.setAppPackage("org.wikipedia.alpha");
        //options.setAppActivity("org.wikipedia.main.MainActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private File getApp() {
        String appPath = "src/test/resources/apps/open-trainer.apk";

        File app = new File(appPath);
        return app;
    }

}
