package ru.perekrestok.pages.components;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class HeaderComponent {
    private final SelenideElement catalogSearchInput = $(".header__main-header input")
            .as("Поле ввода Поиск по каталогу");

    private final SelenideElement saleBtn = $("[href='/cat/d']")
            .as("Кнопка Акции");

    private final SelenideElement receivingMethodBtn = $(".header-delivery-button__darken")
            .as("Кнопка Выберите способ получения");

    private final SelenideElement cartBtn = $(".header__cart-button")
            .as("Кнопка Корзина");
}
