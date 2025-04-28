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
    private final String URL = "https://ok.ru/feed";

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public FeedPage open() {
        logger.info("Opening feed page: " + URL);
        Selenide.open(URL);
        isLoaded();
        return this;
    }

    @Override
    public void isLoaded() {
        logger.info("Checking if FeedPage is loaded");
        webdriver().shouldHave(url(URL));
        validatePageElements();
    }

    public FeedPage clickMessagesButton() {
        logger.info("Clicking messages button");
        messagesButton.shouldBe(visible).click();
        return this;
    }

    public SelenideElement getChatWindow() {
        logger.info("Getting chat window element");
        return chatWindow.shouldBe(visible);
    }

    public void validatePageElements() {
        logger.info("Validating feed page elements");
        messagesButton.shouldBe(visible);
        logger.info("Messages button is correct");
        logger.info("All feed page elements are visible");
    }
}