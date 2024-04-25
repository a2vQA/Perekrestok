package ru.perekrestok.pages.components;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class AgeDisclaimerModal {
    private final SelenideElement content = $("[class$='modal-content'][aria-label='Подтвердите Ваш возраст']")
            .as("Попап Ограничение контента");
    private final SelenideElement confirmAgeBtn = $(".adult-modal-button .button-children")
            .as("Кнопка Мне исполнилось 18 лет");
    private final SelenideElement declineAgeBtn = $(".adult-modal-link .button-children")
            .as("Кнопка Мне меньше 18 лет");
}
