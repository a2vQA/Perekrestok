package ru.perekrestok.mob.pages.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

@Getter
public class BrowserLoginPopup {
    private final SelenideElement closeBrowserBtn = $(id("com.android.chrome:id/close_button"))
            .as("Закрыть браузер регистрации в X5ID");

    public void waitForBrowserPopup() {
        try {
            new WebDriverWait(Selenide.webdriver().driver().getWebDriver(), Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(closeBrowserBtn));
            if (closeBrowserBtn.isDisplayed()) {
                step("Закрыть браузер с авторизацией", () -> {
                    closeBrowserBtn.click();
                });
            }
        } catch (Exception ignored) {
        }
    }
}