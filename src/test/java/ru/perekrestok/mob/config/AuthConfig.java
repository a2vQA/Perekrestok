package ru.perekrestok.mob.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mob/config/auth.properties"
})
public interface AuthConfig extends Config {
    @Config.Key("user.username")
    String getUsername();

    @Config.Key("user.accessKey")
    String getPassword();
}