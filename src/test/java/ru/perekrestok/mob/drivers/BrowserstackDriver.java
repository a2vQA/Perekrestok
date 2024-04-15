package ru.perekrestok.mob.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.perekrestok.mob.config.AuthConfig;
import ru.perekrestok.mob.config.BrowserstackConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", authConfig.getUsername());
        caps.setCapability("browserstack.key", authConfig.getPassword());

        // Set URL of the application under test
        caps.setCapability("app", browserstackConfig.getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", browserstackConfig.getDevice());
        caps.setCapability("os_version", browserstackConfig.getOsVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Perekrestok diploma project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "mob tests");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.getBrowserstackUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
