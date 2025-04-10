package org.example.okmsger.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement searchField = $(byXpath("//*[@id=\"hook_Block_SearchMRB\"]/anonym-users-search/div/div[1]/div[1]/div/div/div/label/input"));
    private final SelenideElement searchButton = $("button[type='submit']");
    private final SelenideElement resultsCountElement = $(byXpath("//*[@id=\"hook_Block_SearchMRB\"]/anonym-users-search/div/div[1]/div[2]/div/h2/span"));
    private final SelenideElement firstButton = $(byXpath("//button[@aria-label='Сервисы VK']"));
    private final SelenideElement secondButton = $(byXpath("//a[contains(@href, 'vk.company/ru/projects')]"));
    private final String url = "https://ok.ru/search/profiles";

    public SearchPage open() {
        Selenide.open(url);
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
}