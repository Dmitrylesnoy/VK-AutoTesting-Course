package org.example.okmsger.pages;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class FeedPage implements Page{
    private final SelenideElement messagesButton = $(byXpath("//li[@data-l='t,discussions']/button"));
    private final SelenideElement chatWindow = $(byXpath("//*[@class='dialogWrapper']"));
    private final String URL = "https://ok.ru/feed/";

    public FeedPage open() {
        Selenide.open(URL);
        return this;
    }

    public FeedPage clickMessagesButton() {
        messagesButton.click();
        return this;
    }

    public SelenideElement getChatWindow() {
        return chatWindow;
    }

    public String getUrl() {
        return URL;
    }
}
