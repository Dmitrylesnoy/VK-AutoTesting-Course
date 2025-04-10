package org.example.okmsger.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;

public class RecoveryPage implements Page {
    private final SelenideElement upperHelpButton = $(byXpath("//a[text()='Помощь' and @class='anon-tb-link']"));
   private final String url = "https://ok.ru/dk?st.cmd=anonymRecoveryStart"; 

    public boolean isHaveHelpButton() {
        return upperHelpButton.isDisplayed();
    }

    public RecoveryPage clickHelpButton() {
        upperHelpButton.click();
        return this;
    }

    public String getUrl() {
        return url;
    }
    public RecoveryPage open() {
        Selenide.open(url);
        return this;
    }
}
