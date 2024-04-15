package ru.perekrestok.web.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class MainPage {
    private final SelenideElement mainCarousel = $(".swiper-container.main-slider")
            .as("Главная карусель предложений");
}
