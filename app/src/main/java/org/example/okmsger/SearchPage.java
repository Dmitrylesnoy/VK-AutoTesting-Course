package org.example.okmsger;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.openqa.selenium.By;

public class SearchPage {
    private final SelenideElement searchField = $(By
            .xpath("//*[@id=\"hook_Block_SearchMRB\"]/anonym-users-search/div/div[1]/div[1]/div/div/div/label/input"));
    private final SelenideElement searchButton = $("button[type='submit']");
    private final SelenideElement resultsCountElement = $(
            By.xpath("//*[@id=\"hook_Block_SearchMRB\"]/anonym-users-search/div/div[1]/div[2]/div/h2/span"));

    // Обновленные XPath для кнопок
    private final SelenideElement firstButton = $(By.xpath("//button[@aria-label='Сервисы VK']"));
    private final SelenideElement secondButton = $(By.xpath("//a[contains(@href, 'vk.company/ru/projects')]"));

    // Элемент для закрытия баннера с куки
    private final SelenideElement cookieAcceptButton = $(By.xpath("//button[contains(@class, 'cb_accept')]"));

    public SearchPage open() {
        Selenide.open("https://ok.ru/search/profiles");
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

    // Метод для закрытия баннера с куки
    public SearchPage acceptCookiesIfPresent() {
        if (cookieAcceptButton.exists()) {
            cookieAcceptButton.click();
        }
        return this;
    }

    public SearchPage clickFirstButton() {
        firstButton.click();
        return this;
    }

    public SearchPage clickSecondButton() {
        secondButton.click();
        return this;
    }

    public String getCurrentUrl() {
        return Selenide.webdriver().driver().getCurrentFrameUrl();
    }
}