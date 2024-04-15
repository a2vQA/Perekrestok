package ru.perekrestok.web.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SalePage {
    private final SelenideElement saleHeader = $(".page-header__title")
            .as("Заголовок Акции и скидки на странице скидок");
}
