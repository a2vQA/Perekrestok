package ru.perekrestok.mob.pages.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class WelcomeCarousel {
    private final SelenideElement closeCarousel = $x("//android.widget.ImageView[@content-desc='Закрыть']")
            .as("Кнопка закрытия Карусели");
}
