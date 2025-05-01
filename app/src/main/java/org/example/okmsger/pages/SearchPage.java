package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.example.okmsger.utils.WebElementWrapper;
import org.openqa.selenium.By;

public class SearchPage extends Page {
    private static final By searchField = By.xpath("//input[@type='search']");
    private static final By searchButton = By.xpath("//button[@aria-label='Найти']");
    private static final By resultsCountElement = By.xpath("//span[@class='counter__2bnlu']");
    private static final By firstButton = By.xpath("//button[@aria-label='Сервисы VK']");
    private static final By secondButton = By.xpath("//a[contains(@href, 'vk.company/ru/projects')]");
    protected static String URL = "https://ok.ru/search/profiles";

    public SearchPage enterSearchQuery(String query) {
        new WebElementWrapper(searchField,"Search input").setValue(query);
        return this;
    }

    public SearchPage clickSearchButton() {
        new WebElementWrapper(searchButton, "Search button").click();
        return this;
    }

    public SearchPage submitSearchWithEnter() {
        new WebElementWrapper(searchField, "Search input fields").pressEnter();
        return this;
    }

    public int getResultsCount() {
        return Integer.parseInt(new WebElementWrapper(resultsCountElement, "Search result count").getText());
    }

    public SearchPage clickFirstButton() {
        new WebElementWrapper(firstButton, "first button").click();
        return this;
    }

    public SearchPage clickSecondButton() {
        new WebElementWrapper(secondButton,"Second button").click();
        return this;
    }

    public void validatePageElements() {
        logger.info("Validating search page elements");
        $(searchField).shouldBe(visible);
        logger.info("Search field is correct");
        $(searchButton).shouldBe(visible);
        logger.info("Search button is correct");
        $(firstButton).shouldBe(visible);
        logger.info("First button is correct");
        $(secondButton).shouldBe(hidden);
        logger.info("Second button is correct");
        logger.info("All search page elements are visible");
    }
}