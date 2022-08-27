package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobile.properties")
public interface MobileConfig extends Config {

    @Key("os_name")
    String os_name();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

    @Key("URL")
    String URL();
}
