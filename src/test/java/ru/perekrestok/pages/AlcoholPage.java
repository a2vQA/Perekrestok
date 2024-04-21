package ru.perekrestok.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class AlcoholPage {
    private final SelenideElement alcoholHeader = $("h1.catalog-category__title")
            .as("Заголовок Алкогольные напитки на странице алкогольной продукции");
}
