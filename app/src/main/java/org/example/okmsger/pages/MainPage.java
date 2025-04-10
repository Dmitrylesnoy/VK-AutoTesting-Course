package org.example.okmsger.pages;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage {
    private final SelenideElement forgotButton = $(byText("Не получается войти?"));
    private final SelenideElement downHelpButton = $(byText("Помощь"));
    private final String url = "https://ok.ru/";

    public boolean isHaveHelpButton() {
        return forgotButton.isDisplayed();
    }

    public MainPage clickForgotButton() {
        forgotButton.click();
        return this;
    }

    public MainPage clickHelpButton() {
        downHelpButton.click();
        return this;
    }

    public String getUrl() {
        return url;
    }

    public MainPage open() {
        Selenide.open(url);
        return this;
    }
}
