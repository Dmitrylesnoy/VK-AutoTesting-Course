package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.example.okmsger.utils.WebElementWrapper;
import org.openqa.selenium.By;


public class RecoveryPage extends Page {
    private final By upperHelpButton = By.xpath("//div[@class='anon-tb-item']/a");
    private final String URL = "https://ok.ru/dk?st.cmd=anonymRecoveryStart";

    public RecoveryPage clickHelpButton() {
        new WebElementWrapper(upperHelpButton, "upper help button").click();
        return this;
    }

    public void validatePageElements() {
        logger.info("Validating recovery page elements");
        $(upperHelpButton).shouldBe(visible);
        logger.info("Help button is correct");
        logger.info("All recovery page elements are visible");
    }
}