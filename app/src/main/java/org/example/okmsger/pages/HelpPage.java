package org.example.okmsger.pages;

import com.codeborne.selenide.Selenide;

public class HelpPage {
    private final String url = "https://ok.ru/help";

    public String getUrl() {
        return url;
    }

    public HelpPage open() {
        Selenide.open(url);
        return this;
    }
}
