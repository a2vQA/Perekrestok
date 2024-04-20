package ru.perekrestok.mob.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AlcoholPage {
    private final SelenideElement content =
            $x("//android.widget.ScrollView/android.widget.LinearLayout[1]/android.widget.FrameLayout")
                    .as("Страница Пиво, сидр");
}
