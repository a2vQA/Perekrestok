package ru.perekrestok.mob.pages.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class Footer {
    private final SelenideElement catalogue =
            $x("(//android.widget.ImageView[@resource-id='ru.perekrestok.app:id/navigation_bar_item_icon_view'])[2]")
            .as("Кнопка Каталог");
}
