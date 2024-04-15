package ru.perekrestok.mob.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mob/config/${deviceHost}.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.device")
    String getDevice();

    @Key("browserstack.deviceOsVersion")
    String getOsVersion();

    @Key("browserstack.app")
    String getApp();

    @Key("browserstack.remoteUrl")
    String getBrowserstackUrl();
}
