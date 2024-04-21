package ru.perekrestok.pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ReceivingMethodPopup {
    private final SelenideElement content = $("[class$='modal-content'][aria-labelledby='delivery-modal-title']")
            .as("Попап Выберите способ получения");
    private final SelenideElement selfPickup =
            $x("//button[@type='button' and not(contains(@class, 'banner-content__button pickup'))][.//p[contains(text(), 'Самовывоз')]]")
            .as("Кнопка способа получения Самовывоз");
    private final SelenideElement displaySelfPickupStoresAsList = $(byTagAndText("p", "Списком"))
            .as("Отображение магазинов для самовывоза списком");
    private final ElementsCollection listOfSelfPickupStores = $$(".store-item__content")
            .as("Список магазинов для самовывоза");
    private final SelenideElement submitStoreBtn = $(".focused-shop-submit")
            .as("Кнопка выбора магазина Подтвердить");
}
