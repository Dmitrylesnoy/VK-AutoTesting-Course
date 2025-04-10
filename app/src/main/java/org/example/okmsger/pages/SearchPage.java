package org.example.okmsger.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage implements Page{
    private final SelenideElement searchField = $(byXpath("//input[@type='search']"));
    private final SelenideElement searchButton = $(byXpath("//button[@type='submit']"));
    private final SelenideElement resultsCountElement = $(byXpath("//span[@class='counter__2bnlu']"));
    private final SelenideElement firstButton = $(byXpath("//button[@aria-label='Сервисы VK']"));
    private final SelenideElement secondButton = $(byXpath("//a[contains(@href, 'vk.company/ru/projects')]"));
    private final String URL = "https://ok.ru/search/profiles";

    public SearchPage open() {
        Selenide.open(URL);
        return this;
    }

    public SearchPage enterSearchQuery(String query) {
        searchField.setValue(query);
        return this;
    }

    public void clickSearchButton() {
        if (searchButton.exists()) {
            searchButton.click();
        } else {
            searchField.pressEnter();
        }
    }

    public int getResultsCount() {
        String countText = resultsCountElement.getText().replaceAll("[^0-9]", "");
        return countText.isEmpty() ? 0 : Integer.parseInt(countText);
    }

    public SearchPage clickFirstButton() {
        firstButton.click();
        return this;
    }

    public SearchPage clickSecondButton() {
        secondButton.click();
        return this;
    }

    public String getUrl() {
        return URL;
    }
}