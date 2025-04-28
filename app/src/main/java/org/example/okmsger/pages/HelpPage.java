package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class HelpPage extends Page {
    private final SelenideElement helpContent = $(By.xpath("//div[@id='help_content']"));
    private final String URL = "https://ok.ru/help";

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public HelpPage open() {
        logger.info("Opening help page: " + URL);
        Selenide.open(URL);
        isLoaded();
        return this;
    }

    @Override
    public void isLoaded() {
        logger.info("Checking if HelpPage is loaded");
        webdriver().shouldHave(url(URL));
        validatePageElements();
    }

    public void validatePageElements() {
        logger.info("Validating help page elements");
        helpContent.shouldBe(visible);
        logger.info("Help content is correct");
        logger.info("All help page elements are visible");
    }
}