package ru.perekrestok.mob.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class CataloguePage {
    private final SelenideElement beerAndCiderPage = $x("//android.widget.TextView[@text='Пиво, сидр']")
            .as("Страница Пиво и сидр");
}
