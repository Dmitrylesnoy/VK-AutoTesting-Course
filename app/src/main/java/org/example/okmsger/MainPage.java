package org.example.okmsger;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage {
    private final SelenideElement logo = $(".toolbar_custom-logo_img:nth-child(1)");
    private final SelenideElement messagesButton = $("#msg_toolbar_button > .toolbar_nav_i_ic");
    private final SelenideElement chatWindow = $(".messenger_layer");

    public MainPage open() {
        Selenide.open("https://ok.ru/feed/");
        return this;
    }

    public MainPage clickLogo() {
        logo.click();
        return this;
    }

    public MainPage clickMessagesButton() {
        messagesButton.click();
        return this;
    }

    public void verifyChatWindowIsOpened() {
        chatWindow.shouldBe(visible);
    }

    public SelenideElement getChatWindow() {
        return chatWindow;
    }
}
