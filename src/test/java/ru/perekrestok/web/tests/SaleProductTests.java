package ru.perekrestok.web.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.perekrestok.web.pages.SalePage;
import ru.perekrestok.web.pages.elements.AgeDisclaimerPopup;
import ru.perekrestok.web.pages.elements.ProductCard;
import ru.perekrestok.web.pages.elements.ProductDetailPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Epic("Perekrestok web")
@Story("Страница Скидки")
@Feature("Аттрибуты скидки у товара")
@Tag("smokeWeb")
public class SaleProductTests extends BaseTest {
    private final ProductCard productCard = new ProductCard();
    private final AgeDisclaimerPopup ageDisclaimerPopup = new AgeDisclaimerPopup();
    private final ProductDetailPage productDetailPage = new ProductDetailPage();
    private final SalePage salePage = new SalePage();

    @BeforeEach
    public void arrange() {
        step("Открыть страницу со скидками", () -> {
            open("/cat/d");
            ageDisclaimerPopup
                    .getConfirmAgeBtn()
                    .click();

            salePage
                    .getSaleHeader()
                    .shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Акции и скидки"));
        });
    }

    @DisplayName("Проверка отображения аттрибутов скидки у скидочного товара")
    @Owner("vvartemenko")
    @Tag("saleAttribution")
    @Test
    public void checkSaleAttributesOnProduct() {
        step("Проверить наличие аттрибутов скидки у первого товара", () -> {
            step("Наличие бейджа скидки", () -> productCard.checkSaleBadgeOnProductCard(1));

            step("Наличие старой и новой цены", () -> productCard.checkPresenceOfTwoPricesOnProductCard(1));
        });

        step("Перейти на детальную страницу первого скидочного товара", () -> productCard
                .getProductCards()
                .get(0)
                .click());

        step("Проверить наличие аттрибутов скидки на детальной странице", () -> {
            step("Наличие бейджа скидки", () -> {
                productDetailPage
                        .getProductPriceLabel()
                        .shouldBe(Condition.visible);
            });

            step("Наличие старой и новой цены", () -> {
                productDetailPage
                        .getOldPrice()
                        .shouldBe(Condition.visible);
                productDetailPage
                        .getNewPrice()
                        .shouldBe(Condition.visible);
            });
        });
    }
}
