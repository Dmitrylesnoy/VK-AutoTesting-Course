package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

public class HelpPage extends Page {
    private static final By helpContent = By.xpath("//div[@id='hook_Block_MainContainer']");
    private static final String URL = "https://ok.ru/help";

    public void validatePageElements() {
        logger.info("Validating help page elements");
        $(helpContent).shouldBe(visible);
        logger.info("Help content is visible");
        logger.info("All help page elements are visible");
    }
}
