package ru.perekrestok.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

@Getter
public class ProductCard {
    private final ElementsCollection productCardTitles = $$(".product-card__title")
            .as("Список названий товаров на странице");

    private final ElementsCollection productCards = $$x("//div[contains(@class, 'product-card-wrapper')]")
            .as("Список карточек товаров на странице");

    public void checkSaleBadgeOnProductCard(int index) {
        productCards
                .get(index)
                .$x(".//div[contains(@class, 'product-card__badges')]")
                .shouldBe(Condition.visible);
    }

    public void checkPresenceOfTwoPricesOnProductCard(int index) {
        productCards
                .get(index)
                .$x(".//div[@class='price-old']")
                .shouldBe(Condition.visible);
        productCards
                .get(index)
                .$x(".//div[@class='price-new']")
                .shouldBe(Condition.visible);
    }

    public void addProductToCart(int index) {
        productCards
                .get(index)
                .$x(".//button[contains(@class, 'cart-add-button')]")
                .shouldBe(Condition.visible)
                .click();

        productCards
                .get(index)
                .$x(".//button[contains(@class, 'cart-add-button')]")
                .shouldNotBe(Condition.visible);
    }
}
