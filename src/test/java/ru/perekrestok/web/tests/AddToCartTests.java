package ru.perekrestok.web.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.perekrestok.web.pages.CartPage;
import ru.perekrestok.web.pages.elements.AgeDisclaimerPopup;
import ru.perekrestok.web.pages.elements.Header;
import ru.perekrestok.web.pages.elements.ProductCard;
import ru.perekrestok.web.pages.elements.ProductDetailPage;
import ru.perekrestok.web.pages.elements.ReceivingMethodPopup;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Epic("Perekrestok web")
@Story("Корзина")
@Feature("Добавление товара в корзину")
@Tag("smokeWeb")
public class AddToCartTests extends BaseTest {
    private final Header header = new Header();
    private final ReceivingMethodPopup receivingMethodPopup = new ReceivingMethodPopup();
    private final AgeDisclaimerPopup ageDisclaimerPopup = new AgeDisclaimerPopup();
    private final ProductCard productCard = new ProductCard();
    private final ProductDetailPage productDetailPage = new ProductDetailPage();
    private final CartPage cartPage = new CartPage();
    private String productName;

    @BeforeEach
    public void arrange() {
        step("Открыть главную страницу и указать способ получения - Самовывоз и перейти на страницу Скидки", () -> {
            open("");
            header
                    .getReceivingMethodBtn()
                    .click();

            receivingMethodPopup
                    .getContent()
                    .shouldBe(Condition.visible);

            receivingMethodPopup
                    .getSelfPickup()
                    .click();
            receivingMethodPopup
                    .getDisplaySelfPickupStoresAsList()
                    .click();
            receivingMethodPopup
                    .getListOfSelfPickupStores()
                    .get(0)
                    .click();
            receivingMethodPopup
                    .getSubmitStoreBtn()
                    .click();

            receivingMethodPopup
                    .getContent()
                    .shouldNotBe(Condition.visible);

            open("/cat/d");
            ageDisclaimerPopup
                    .getConfirmAgeBtn()
                    .click();
        });
    }

    @DisplayName("Добавление товара в корзину из списка товаров")
    @Owner("vvartemenko")
    @Tag("addToCartFromList")
    @Test
    public void addToCartFromProductListTest() {
        step("Запомнить название первого товара", () -> {
            productName = productCard
                    .getProductCardTitles()
                    .get(0)
                    .getText();
        });

        step("Нажать кнопку Добавить в корзину у первого товара", () -> {
            productCard.addProductToCart(0);
        });

        step("Перейти в корзину", () -> {
            header
                    .getCartBtn()
                    .click();
        });

        step("Проверить, что добавленный товар находится в корзине", () -> {
            cartPage
                    .getCartHeader()
                    .shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Корзина"));
            cartPage
                    .getProductTitlesInCart()
                    .shouldHave(CollectionCondition.texts(productName));
        });
    }

    @DisplayName("Добавление товара в корзину с детальной страницы")
    @Owner("vvartemenko")
    @Tag("addToCartFromDetailPage")
    @Test
    public void addToCartFromProductDetailPageTest() {
        step("Перейти на детальную страницу первого товара", () -> productCard
                .getProductCards()
                .get(0)
                .click());

        step("Запомнить название товара", () -> {
            productName = productDetailPage
                    .getProductName()
                    .getText();
        });

        step("Нажать кнопку Добавить в корзину на детальной странице", () -> productDetailPage
                .getAddToCartBtn()
                .click());

        step("Перейти в корзину", () -> header
                .getCartBtn()
                .click());

        step("Проверить, что добавленный товар находится в корзине", () -> {
            cartPage
                    .getCartHeader()
                    .shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Корзина"));
            cartPage
                    .getProductTitlesInCart()
                    .shouldHave(CollectionCondition.texts(productName));
        });
    }
}
