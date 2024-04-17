package ru.perekrestok.mob.pages.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

@Getter
public class BrowserLoginPopup {
    private final SelenideElement closeBrowserBtn = $(id("com.android.chrome:id/close_button"))
            .as("Закрыть браузер регистрации в X5ID");

}
