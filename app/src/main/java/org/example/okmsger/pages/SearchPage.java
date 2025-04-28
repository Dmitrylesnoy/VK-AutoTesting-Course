package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SearchPage extends Page {
    private final SelenideElement searchField = $(By.xpath("//input[@type='search']"));
    private final SelenideElement searchButton = $(By.xpath("//button[@aria-label='Найти']"));
    private final SelenideElement resultsCountElement = $(By.xpath("//span[@class='counter__2bnlu']"));
    private final SelenideElement firstButton = $(By.xpath("//button[@aria-label='Сервисы VK']"));
    private final SelenideElement secondButton = $(By.xpath("//a[contains(@href, 'vk.company/ru/projects')]"));
    private final String URL = "https://ok.ru/search/profiles";

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public SearchPage open() {
        logger.info("Opening search page: " + URL);
        Selenide.open(URL);
        isLoaded();
        return this;
    }

    @Override
    public void isLoaded() {
        logger.info("Checking if SearchPage is loaded");
        webdriver().shouldHave(url(URL));
        validatePageElements();
    }

    public SearchPage enterSearchQuery(String query) {
        logger.info("Entering search query: " + query);
        searchField.shouldBe(visible).setValue(query);
        return this;
    }

    public void clickSearchButton() {
        logger.info("Clicking search button");
        searchButton.shouldBe(visible).click();
    }

    public void submitSearchWithEnter() {
        logger.info("Submitting search with Enter");
        searchField.shouldBe(visible).pressEnter();
    }

    public int getResultsCount() {
        logger.info("Getting results count");
        String countText = resultsCountElement.shouldBe(visible).getText().replaceAll("[^0-9]", "");
        int count = countText.isEmpty() ? 0 : Integer.parseInt(countText);
        logger.info("Results count: " + count);
        return count;
    }

    public SearchPage clickFirstButton() {
        logger.info("Clicking first button");
        firstButton.shouldBe(visible).click();
        return this;
    }

    public SearchPage clickSecondButton() {
        logger.info("Clicking second button");
        secondButton.shouldBe(visible).click();
        return this;
    }

    public void validatePageElements() {
        logger.info("Validating search page elements");
        searchField.shouldBe(visible);
        logger.info("Search field is correct");
        searchButton.shouldBe(visible);
        logger.info("Search button is correct");
        // resultsCountElement.shouldBe(visible);
        // logger.info("Results count element is correct");
        firstButton.shouldBe(visible);
        logger.info("First button is correct");
        secondButton.shouldBe(hidden);
        logger.info("Second button is correct");
        logger.info("All search page elements are visible");
    }
}