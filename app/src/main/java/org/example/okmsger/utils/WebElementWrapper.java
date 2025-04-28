package org.example.okmsger.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;

public class WebElementWrapper {
    private static final Logger logger = Logger.getLogger(WebElementWrapper.class.getName());
    private final By locator;
    private final String name;

    public WebElementWrapper(By locator, String name) {
        this.locator = locator;
        this.name = name;
        isDisplayed();
    }

    public void click() {
        logger.info("Clicking on element: " + name);
        $(locator).click();
        logger.info(name + " clicked");
    }

    public void setValue(String value) {
        logger.info("Setting value for element " + name + ": " + value);
        $(locator).shouldBe(Condition.visible).setValue(value);
    }

    public void pressEnter() {
        logger.info("Pressing Enter on element: " + name);
        $(locator).shouldBe(Condition.visible).pressEnter();
    }

    public String getText() {
        String text = $(locator).shouldBe(Condition.visible).getText();
        logger.info("Getting text from element " + name + ": " + text);
        return text;
    }

    public SelenideElement getElement() {
        logger.info("Getting element: " + name);
        return $(locator).shouldBe(Condition.visible);
    }

    public void isDisplayed() {
        $(locator).shouldBe(Condition.visible);
        logger.info("Element " + name + " is visible");
    }
}