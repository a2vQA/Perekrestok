package ru.perekrestok.tests;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.perekrestok.pages.CartPage;
import ru.perekrestok.pages.ProductDetailPage;
import ru.perekrestok.pages.components.AgeDisclaimerModal;
import ru.perekrestok.pages.components.HeaderComponent;
import ru.perekrestok.pages.components.ProductCardComponent;
import ru.perekrestok.pages.components.ReceivingMethodModal;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Epic("Perekrestok web")
@Story("Корзина")
@Feature("Добавление товара в корзину")
@Tags({@Tag("smoke"), @Tag("cart")})
public class AddToCartTests extends BaseTest {
    private final HeaderComponent headerComponent = new HeaderComponent();
    private final ReceivingMethodModal receivingMethodModal = new ReceivingMethodModal();
    private final AgeDisclaimerModal ageDisclaimerModal = new AgeDisclaimerModal();
    private final ProductCardComponent productCardComponent = new ProductCardComponent();
    private final ProductDetailPage productDetailPage = new ProductDetailPage();
    private final CartPage cartPage = new CartPage();
    private String productName;

    @BeforeEach
    public void arrange() {
        step("Открыть главную страницу, указать способ получения - Самовывоз и перейти на страницу Вино", () -> {
            open("");
            headerComponent
                    .getReceivingMethodBtn()
                    .click();

            receivingMethodModal
                    .getContent()
                    .shouldBe(Condition.visible);

            receivingMethodModal
                    .getSelfPickup()
                    .click();
            receivingMethodModal
                    .getDisplaySelfPickupStoresAsList()
                    .click(ClickOptions.withTimeout(Duration.ofSeconds(20)));
            receivingMethodModal
                    .getListOfSelfPickupStores()
                    .get(0)
                    .click(ClickOptions.withTimeout(Duration.ofSeconds(20)));
            receivingMethodModal
                    .getSubmitStoreBtn()
                    .click();

            receivingMethodModal
                    .getContent()
                    .shouldNotBe(Condition.visible);

            open("/cat/c/2/vino");
            ageDisclaimerModal
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
            productName = productCardComponent
                    .getProductCardTitles()
                    .get(0)
                    .getText();
        });

        step("Нажать кнопку Добавить в корзину у первого товара", () -> {
            productCardComponent.addProductToCart(0);
        });

        step("Перейти в корзину", () -> {
            headerComponent
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
        step("Перейти на детальную страницу первого товара", () -> productCardComponent
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

        step("Перейти в корзину", () -> headerComponent
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
