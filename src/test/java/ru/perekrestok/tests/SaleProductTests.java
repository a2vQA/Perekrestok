package ru.perekrestok.tests;

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
import ru.perekrestok.pages.ProductDetailPage;
import ru.perekrestok.pages.SalePage;
import ru.perekrestok.pages.components.AgeDisclaimerModal;
import ru.perekrestok.pages.components.ProductCardComponent;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Epic("Perekrestok web")
@Story("Страница Скидки")
@Feature("Аттрибуты скидки у товара")
@Tags({@Tag("smoke"), @Tag("sale")})
public class SaleProductTests extends BaseTest {
    private final ProductCardComponent productCardComponent = new ProductCardComponent();
    private final AgeDisclaimerModal ageDisclaimerModal = new AgeDisclaimerModal();
    private final ProductDetailPage productDetailPage = new ProductDetailPage();
    private final SalePage salePage = new SalePage();

    @BeforeEach
    public void arrange() {
        step("Открыть страницу со скидками", () -> {
            open("/cat/d");
            ageDisclaimerModal
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
            step("Наличие бейджа скидки", () -> productCardComponent.checkSaleBadgeOnProductCard(0));

            step("Наличие старой и новой цены", () -> productCardComponent.checkPresenceOfTwoPricesOnProductCard(0));
        });

        step("Перейти на детальную страницу первого скидочного товара", () -> productCardComponent
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
