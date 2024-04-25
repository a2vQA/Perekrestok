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
import ru.perekrestok.pages.AlcoholPage;
import ru.perekrestok.pages.MainPage;
import ru.perekrestok.pages.components.AgeDisclaimerModal;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Epic("Perekrestok web")
@Story("Попап подтверждения возраста")
@Feature("Прохождение попапа подтверждения возраста")
@Tags({@Tag("smoke"), @Tag("agePopup")})
public class AgeDisclaimerTests extends BaseTest {
    private final AgeDisclaimerModal ageDisclaimerModal = new AgeDisclaimerModal();
    private final AlcoholPage alcoholPage = new AlcoholPage();
    private final MainPage mainPage = new MainPage();

    @BeforeEach
    public void arrange() {
        step("Открыть страницу с алкогольной продукцией", () ->
                open("/cat/mc/1/alkogolnye-napitki"));
    }

    @DisplayName("Подтверждение 18-летия в попапе возрастного ограничение")
    @Owner("vvartemenko")
    @Tag("ageDisclaimerPositive")
    @Test
    public void checkConfirmAgeDisclaimerTest() {
        step("Подтвердить 18-летие в попапе возрастного ограничения", () -> ageDisclaimerModal
                .getConfirmAgeBtn()
                .click());

        step("Проверить отображение страницы Акции и скидки", () -> {
            alcoholPage
                    .getAlcoholHeader()
                    .shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Алкогольные напитки"));
        });
    }

    @DisplayName("Отклонение 18-летия в попапе возрастного ограничение")
    @Owner("vvartemenko")
    @Tag("ageDisclaimerNegative")
    @Test
    public void checkDeclineAgeDisclaimerTest() {
        step("Нажать кнопку Мне меньше 18 лет", () -> ageDisclaimerModal
                .getDeclineAgeBtn()
                .click());

        step("Проверить отображение главной страницы", () -> {
            alcoholPage
                    .getAlcoholHeader()
                    .shouldNotBe(Condition.visible);
            mainPage
                    .getMainCarousel()
                    .shouldBe(Condition.visible);
        });
    }
}
