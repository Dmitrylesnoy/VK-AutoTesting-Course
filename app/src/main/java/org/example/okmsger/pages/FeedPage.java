package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class FeedPage extends Page {
    private final SelenideElement messagesButton = $(By.xpath("//li[@data-l='t,discussions']/button"));
    private final SelenideElement chatWindow = $(By.xpath("//*[@class='dialogWrapper']"));
    private final String URL = "https://ok.ru/feed/";

    public FeedPage() {
        logger.info("Initializing FeedPage");
        open();
    }

    public FeedPage open() {
        logger.info("Opening feed page: " + URL);
        Selenide.open(URL);
        // webdriver().shouldHave(url(URL));
        validatePageElements();
        return this;
    }

    public FeedPage clickMessagesButton() {
        logger.info("Clicking messages button");
        $(messagesButton).shouldBe(visible).click();
        return this;
    }

    public SelenideElement getChatWindow() {
        logger.info("Getting chat window element");
        return $(chatWindow);
    }

    public String getUrl() {
        return URL;
    }

    public void validatePageElements() {
        $(messagesButton).shouldBe(visible);
        logger.info("Messages button is correct");
        $(chatWindow).shouldBe(visible);
        logger.info("Chat window is correct");
        logger.info("All feed page elements are visible");
    }
}
