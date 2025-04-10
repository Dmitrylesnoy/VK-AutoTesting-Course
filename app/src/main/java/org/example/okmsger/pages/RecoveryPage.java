package org.example.okmsger.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;

public class RecoveryPage {
    private final SelenideElement upperHelpButton = $(byXpath("//*[@id=\"hook_Block_Header\"]/div/div/div/div[2]/div[2]/a"));
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
