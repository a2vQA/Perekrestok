package ru.perekrestok.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class CartPage {
    private final SelenideElement cartHeader = $("h1.page-title")
            .as("Заголовок Корзина на странице корзины");

    private final ElementsCollection productTitlesInCart = $$(".product-name")
            .as("Список названий товаров в корзине");
}
