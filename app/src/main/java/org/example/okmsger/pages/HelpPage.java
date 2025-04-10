package org.example.okmsger.pages;

import com.codeborne.selenide.Selenide;

public class HelpPage implements Page {
    private final String URL = "https://ok.ru/help";

    public String getUrl() {
        return URL;
    }

    public HelpPage open() {
        Selenide.open(URL);
        return this;
    }
}
