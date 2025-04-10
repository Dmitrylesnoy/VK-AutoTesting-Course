package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class FeedPage implements Page{
    private final SelenideElement logo = $(byXpath("//*[@id=\"topPanelLeftCorner\"]"));
    private final SelenideElement messagesButton = $(byXpath("//*[@id=\"hook_ToolbarIconDiscussions_ToolbarDiscussions\"]"));
    private final SelenideElement chatWindow = $(byXpath("//*[@id=\"topPanelPopup_d\"]/div[2]/div/div[1]"));
    private final String url = "https://ok.ru/feed/";

    public FeedPage open() {
        Selenide.open(url);
        return this;
    }

    public FeedPage clickLogo() {
        logo.click();
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
        return url;
    }
}
