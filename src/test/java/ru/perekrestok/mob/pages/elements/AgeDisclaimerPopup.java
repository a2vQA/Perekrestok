package ru.perekrestok.mob.pages.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AgeDisclaimerPopup {
    private final SelenideElement content =
            $x("//android.widget.FrameLayout[@resource-id='ru.perekrestok.app:id/design_bottom_sheet']" +
                    "/android.widget.FrameLayout/android.widget.LinearLayout")
                    .as("Попап Ограничение контента");

    private final SelenideElement confirmAgeBtn = $x("//android.widget.TextView[@text='Мне есть 18 лет']")
            .as("Мне есть 18 лет");

    private final SelenideElement declineAgeBtn = $x("//android.widget.TextView[@text='Мне нет 18 лет']")
            .as("Мне нет 18 лет");

}
