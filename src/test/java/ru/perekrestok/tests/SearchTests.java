package ru.perekrestok.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.perekrestok.pages.MainPage;
import ru.perekrestok.pages.components.HeaderComponent;
import ru.perekrestok.pages.components.ProductCardComponent;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Epic("Perekrestok web")
@Story("Поиск")
@Feature("Поиск товара")
@Tags({@Tag("smoke"), @Tag("search")})
public class SearchTests extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final HeaderComponent headerComponent = new HeaderComponent();
    private final ProductCardComponent productCardComponent = new ProductCardComponent();

    @DisplayName("Поиск товара с помощью поисковой строки")
    @Owner("vvartemenko")
    @Tag("search")
    @ValueSource(strings = {"кофе egoiste", "голубика", "масло сливочное"})
    @ParameterizedTest(name = "Заполнение поля поиска значением \"{0}\"")
    public void searchTest(String searchValue) {
        step("Открыть главную страницу perekrestok.ru", () -> {
            open("");
            mainPage
                    .getMainCarousel()
                    .shouldBe(Condition.visible);
        });

        step(format("Вписать в строку Поиск по каталогу - %s и нажать Enter", searchValue), () -> {
            headerComponent
                    .getCatalogSearchInput()
                    .shouldBe(Condition.visible);
            headerComponent
                    .getCatalogSearchInput()
                    .setValue(searchValue)
                    .pressEnter();
        });

        step(format("Проверить отображение товара %s среди результатов поиска", searchValue), () -> {
            productCardComponent
                    .getProductCardTitles()
                    .get(0)
                    .shouldBe(Condition.visible, Duration.ofSeconds(20))
                    .shouldHave(Condition.text(searchValue));
        });
    }
}
