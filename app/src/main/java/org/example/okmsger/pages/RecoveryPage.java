package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class RecoveryPage extends Page {
    private final SelenideElement upperHelpButton = $(By.xpath("//div[@class='anon-tb-item']/a"));
    private final String URL = "https://ok.ru/dk?st.cmd=anonymRecoveryStart";

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public RecoveryPage open() {
        logger.info("Opening recovery page: " + URL);
        Selenide.open(URL);
        isLoaded();
        return this;
    }

    @Override
    public void isLoaded() {
        logger.info("Checking if RecoveryPage is loaded");
        webdriver().shouldHave(url(URL));
        validatePageElements();
    }

    public boolean isHaveHelpButton() {
        boolean isDisplayed = upperHelpButton.shouldBe(visible).isDisplayed();
        logger.info("Help button displayed: " + isDisplayed);
        return isDisplayed;
    }

    public RecoveryPage clickHelpButton() {
        logger.info("Clicking help button");
        upperHelpButton.shouldBe(visible).click();
        return this;
    }

    public void validatePageElements() {
        logger.info("Validating recovery page elements");
        upperHelpButton.shouldBe(visible);
        logger.info("Help button is correct");
        logger.info("All recovery page elements are visible");
    }
}