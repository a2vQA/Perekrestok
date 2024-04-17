package ru.perekrestok.mob.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LoginPage {
    private final SelenideElement skipBtn = $x("//android.widget.TextView[@text='Пропустить']")
            .as("Кнопка Пропустить на экране авторизации");
}
