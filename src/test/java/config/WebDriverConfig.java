package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${host}.properties")
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://google.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("FIREFOX")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("103.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("true")
    boolean remote();

}
