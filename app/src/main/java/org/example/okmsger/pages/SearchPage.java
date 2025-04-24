package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SearchPage extends Page{
    private final SelenideElement searchField = $(By.xpath("//input[@type='search']"));
    private final SelenideElement searchButton = $(By.xpath("//div[@role='search']/button"));
    private final SelenideElement resultsCountElement = $(
            By.xpath("//div[@role='tabpanel' and @id='tabpanel-users' and @data-l]/div/div/h2"));
    private final SelenideElement firstButton = $(By.xpath("//button[@aria-label='Сервисы VK']"));
    private final SelenideElement secondButton = $(By.xpath("//a[contains(@href, 'vk.company/ru/projects')]"));
    private final String URL = "https://ok.ru/search/profiles";

    // public SearchPage() {
    // open();
    // validatePageElemets();
    // }

    public SearchPage open() {
        logger.info("Opening search page: " + URL);
        Selenide.open(URL);
        // webdriver().shouldHave(url(URL));
        validatePageElements();
        return this;
    }

    public SearchPage enterSearchQuery(String query) {
        logger.info("Entering search query: " + query);
        $(searchField).setValue(query);
        return this;
    }

    public void clickSearchButton() {
        logger.info("Clicking search button");
        if ($(searchButton).exists()) {
            $(searchButton).click();
        } else {
            $(searchField).pressEnter();
        }
    }

    public int getResultsCount() {
        logger.info("Getting results count");
        String countText = $(resultsCountElement).getText().replaceAll("[^0-9]", "");
        int count = countText.isEmpty() ? 0 : Integer.parseInt(countText);
        logger.info("Results count: " + count);
        return count;
    }

    public SearchPage clickFirstButton() {
        logger.info("Clicking first button");
        $(firstButton).click();
        return this;
    }

    public SearchPage clickSecondButton() {
        logger.info("Clicking second button");
        $(secondButton).click();
        return this;
    }

    public String getUrl() {
        return URL;
    }

    public void validatePageElements() {
        logger.info("Validating search page elements");
        $(searchField).shouldBe(visible);
        logger.info("Search field is correct");
        $(searchButton).shouldBe(visible);
        logger.info("Search button is correct");
        $(resultsCountElement).shouldBe(visible);
        logger.info("Results count element is correct");
        $(firstButton).shouldBe(visible);
        logger.info("First button is correct");
        $(secondButton).shouldBe(visible);
        logger.info("Second button is correct");
        logger.info("All search page elements are visible");

    }
}
