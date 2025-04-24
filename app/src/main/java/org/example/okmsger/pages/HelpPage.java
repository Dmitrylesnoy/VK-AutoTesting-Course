package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

import com.codeborne.selenide.Selenide;

public class HelpPage extends Page {
    private final String URL = "https://ok.ru/help";
    private final String helpButtonSelector = "button#help";
    private final String helpContentSelector = "div.help-content";

    // public HelpPage() {
        // open();
        // validatePageElements();
    // }

    public String getUrl() {
        return URL;
    }

    public HelpPage open() {
        Selenide.open(URL);
        webdriver().shouldHave(url(URL));
        validatePageElements();
        return this;
    }

    public void validatePageElements() {
        $(helpButtonSelector).shouldBe(visible);
        $(helpContentSelector).shouldBe(visible);
    }
}
