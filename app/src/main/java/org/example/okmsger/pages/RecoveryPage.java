package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;
import static com.codeborne.selenide.WebDriverConditions.url;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

public class RecoveryPage extends Page {
    private static final Logger logger = Logger.getLogger(RecoveryPage.class.getName());
    private final SelenideElement upperHelpButton = $(By.xpath("//a[text()='Помощь' and @class='anon-tb-link']"));
    private final String URL = "https://ok.ru/dk?st.cmd=anonymRecoveryStart";

    public RecoveryPage() {
        logger.info("Initializing RecoveryPage");
        open();
        validatePageElements();
    }

    public boolean isHaveHelpButton() {
        logger.info("Checking if help button is displayed");
        boolean isDisplayed = $(upperHelpButton).isDisplayed();
        logger.info("Help button displayed: " + isDisplayed);
        return isDisplayed;
    }

    public RecoveryPage clickHelpButton() {
        logger.info("Clicking help button");
        $(upperHelpButton).shouldBe(visible).click();
        return this;
    }

    public String getUrl() {
        return URL;
    }

    public RecoveryPage open() {
        logger.info("Opening recovery page: " + URL);
        Selenide.open(URL);
        webdriver().shouldHave(url(URL));
        validatePageElements();
        return this;
    }

    public void validatePageElements() {
        $(upperHelpButton).shouldBe(visible);
        logger.info("Help button is correct");
    }
}
