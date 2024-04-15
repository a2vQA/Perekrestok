package ru.perekrestok.mob.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@Epic("Perekrestok mob")
@Story("Первый запуск")
@Feature("Прохождение онбординга")
@Tag("smokeMob")
public class FirstStartTests extends BaseTest {

    @DisplayName("Успешное отображение 4ех экранов онбординга при первом запуске")
    @Owner("vvartemenko")
    @Tag("onboardingPass")
    @Test
    void checkOnboardingInfoTest() {
//        step("Отклонение уведомлений", () -> {
//            $(id("com.android.permissioncontroller:id/permission_deny_button")).click();
//        });

        step("Первая страница онбординга имеет заголовок \"The Free Encyclopedia …in over 300 languages\"", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(xpath("//android.widget.ImageView[@content-desc='Закрыть']")).click();
        });
    }
}
