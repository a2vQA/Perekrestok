package ru.perekrestok.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProductDetailPage {
    private final SelenideElement productPriceLabel = $(".product__price-labels").as("Бейдж скидки");
    private final SelenideElement newPrice = $("#price-card .price-new").as("Скидочная цена");
    private final SelenideElement oldPrice = $("#price-card .price-old").as("Прошлая цена");
    private final SelenideElement productName = $("h1[itemprop='name']").as("Название товара");
    private final SelenideElement addToCartBtn = $("#price-card [class$='cart-add-button']")
            .as("Кнопка В корзину");
}
