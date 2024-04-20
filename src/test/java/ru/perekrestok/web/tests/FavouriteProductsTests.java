package ru.perekrestok.web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.perekrestok.web.annotations.Manual;

import static io.qameta.allure.Allure.step;

@Epic("Perekrestok web")
@Story("Избранные товары")
@Feature("Добавление товаров в Избранные товары")
@Tag("smokeWeb")
public class FavouriteProductsTests extends BaseTest {

    @BeforeEach
    public void arrange() {
        step("Открыть страницу со скидками и подтвердить 18-летие в попапе возрастного ограничения", () -> {
        });
    }

    @DisplayName("Проверка добавление товара в Избранные товары из списка товаров")
    @Owner("vvartemenko")
    @Manual
    @Test
    public void checkFavouriteProductsFromProductsList() {
        step("Запомнить название первого товара", () -> {
        });

        step("Нажать кнопку Добавить в избранное у первого товара", () -> {
        });

        step("Проверить, что кнопка изменила цвет на красный", () -> {
        });

        step("Перейти в избранные товары", () -> {
        });

        step("Проверить, что товар находится на странице", () -> {
        });
    }

    @DisplayName("Проверка добавление товара в Избранные товары с детальной страницы")
    @Owner("vvartemenko")
    @Manual
    @Test
    public void checkFavouriteProductsFromProductDetailPage() {
        step("Перейти на страницу товара", () -> {
        });

        step("Нажать кнопку Добавить в избранное", () -> {
        });

        step("Проверить, что кнопка изменила цвет на красный", () -> {
        });

        step("Перейти в избранные товары", () -> {
        });

        step("Проверить, что товар находится на странице", () -> {
        });
    }
}
