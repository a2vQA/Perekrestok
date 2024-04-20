package ru.perekrestok.mob.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.perekrestok.mob.pages.AlcoholPage;
import ru.perekrestok.mob.pages.CataloguePage;
import ru.perekrestok.mob.pages.LoginPage;
import ru.perekrestok.mob.pages.elements.AgeDisclaimerPopup;
import ru.perekrestok.mob.pages.elements.BrowserLoginPopup;
import ru.perekrestok.mob.pages.elements.Footer;

import static io.qameta.allure.Allure.step;

@Epic("Perekrestok mob")
@Story("Попап подтверждения возраста")
@Feature("Прохождение попапа подтверждения возраста")
@Tag("smokeMob")
public class AgeDisclaimerTests extends BaseTest {
    private final BrowserLoginPopup browserLoginPopup = new BrowserLoginPopup();
    private final LoginPage loginPage = new LoginPage();
    private final Footer footer = new Footer();
    private final CataloguePage cataloguePage = new CataloguePage();
    private final AgeDisclaimerPopup ageDisclaimerPopup = new AgeDisclaimerPopup();
    private final AlcoholPage alcoholPage = new AlcoholPage();

    @BeforeEach
    public void arrange() {
        Selenide.back();
        browserLoginPopup.waitForBrowserPopup();
        step("Нажать кнопку Пропустить на экране авторизации", () -> loginPage.getSkipBtn().click());
    }

    @DisplayName("Подтверждение 18-летия в попапе возрастного ограничение")
    @Owner("vvartemenko")
    @Tag("mob_ageDisclaimerPositive")
    @Test
    void checkConfirmAgeDisclaimerTest() {
        step("Нажать кнопку Каталог", () -> {
            footer.getCatalogue().click();
        });

        step("Нажать страницу Пиво и сидр", () -> {
            cataloguePage.getBeerAndCiderPage().click();
        });

        step("Проверить, что отображается попап Ограничение контента", () -> {
            ageDisclaimerPopup.getContent().shouldBe(Condition.visible);
        });

        step("Нажать кнопку Мне есть 18 лет", () -> {
            ageDisclaimerPopup.getConfirmAgeBtn().click();
        });

        step("Проверить, что отображается страница Пиво, сидр", () -> {
            alcoholPage.getContent().shouldBe(Condition.visible);
        });
    }
}
