package ru.perekrestok.mob.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.perekrestok.mob.pages.AlcoholPage;
import ru.perekrestok.mob.pages.CataloguePage;
import ru.perekrestok.mob.pages.LoginPage;
import ru.perekrestok.mob.pages.elements.AgeDisclaimerPopup;
import ru.perekrestok.mob.pages.elements.BrowserLoginPopup;
import ru.perekrestok.mob.pages.elements.Footer;
import ru.perekrestok.mob.pages.elements.WelcomeCarousel;

import static io.qameta.allure.Allure.step;

@Epic("Perekrestok mob")
@Story("Первый запуск")
@Feature("Прохождение онбординга")
@Tag("smokeMob")
public class FirstStartTests extends BaseTest {
    private final WelcomeCarousel welcomeCarousel = new WelcomeCarousel();
    private final BrowserLoginPopup browserLoginPopup = new BrowserLoginPopup();
    private final LoginPage loginPage = new LoginPage();
    private final Footer footer = new Footer();
    private final CataloguePage cataloguePage = new CataloguePage();
    private final AgeDisclaimerPopup ageDisclaimerPopup = new AgeDisclaimerPopup();
    private final AlcoholPage alcoholPage = new AlcoholPage();

    @DisplayName("Успешное отображение 4ех экранов онбординга при первом запуске")
    @Owner("vvartemenko")
    @Tag("onboardingPass")
    @Test
    void checkOnboardingInfoTest() {
        step("Нажать кнопку Крестик в карусели", () -> {
            welcomeCarousel.getCloseCarousel().click();
        });

        step("Закрыть браузер с авторизацией", () -> {
            browserLoginPopup.getCloseBrowserBtn().click();
        });

        step("Нажать кнопку Пропустить на экране авторизации", () -> {
            loginPage.getSkipBtn().click();
        });

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
