package ru.perekrestok.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${env}.properties"
})
public interface DriverConfig extends Config {
    @Key("browser.name")
    String browserName();

    @Key("browser.version")
    String browserVersion();

    @Key("browser.size")
    String browserSize();

    @Key("browser.remote.url")
    String browserRemoteUrl();

    @Key("is.remote")
    Boolean isRemote();

    @Key("base.url")
    String baseUrl();
}