package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.example.okmsger.utils.WebElementWrapper;
import org.openqa.selenium.By;

public class FeedPage extends Page {
    private static final By messagesButton = By.xpath("//button[@id='msg_toolbar_button']");
    private static final By chatWindow = By.xpath("//*[@id='hook_Block_MessagesLayer']");
    private static final By chatItem = By.xpath("//*[@data-l='t,chatsListItem']/a");
    private static final By messageInput = By.xpath("//div[@data-tsid='write_msg_input-input']/div");
    private static final By sendButton = By.xpath("//button[@data-l='t,sendButton']");
    private static final String URL = "https://ok.ru/feed";

    public FeedPage clickMessagesButton() {
        new WebElementWrapper(messagesButton, "Messages button").click();
        return this;
    }

    public FeedPage clickChat() {
        new WebElementWrapper(chatItem, "Chat item").click();
        validateChatElements();
        return this;
    }

    public FeedPage sendMessage(String message) {
        new WebElementWrapper(messageInput, "Message input").setValue(message);
        new WebElementWrapper(sendButton, "Send button").click();
        return this;
    }

    public FeedPage checkChatWinrow() {
        new WebElementWrapper(chatWindow,"Chats window").isDisplayed();
        logger.info("Chat elements is visible");
        return this;
    }

    public void validatePageElements() {
        logger.info("Validating feed page elements");
        $(messagesButton).shouldBe(visible);
        logger.info("Messages button is correct");
        logger.info("All feed page elements are visible");
    }

    public void validateChatElements() {
        logger.info("Validating chat elements");
        $(chatWindow).shouldBe(visible);
        logger.info("Chat window is correct");
        $(messageInput).shouldBe(visible);
        logger.info("Message input is correct");
        $(sendButton).shouldBe(visible);
        logger.info("Send button is correct");
        logger.info("All chat elements are visible");
    }
}