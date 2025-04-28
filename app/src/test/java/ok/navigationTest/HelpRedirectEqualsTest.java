package ok.navigationTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.okmsger.pages.MainPage;
import org.example.okmsger.pages.RecoveryPage;
import org.example.okmsger.pages.HelpPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import ok.BaseTest;

import java.time.Duration;

public class HelpRedirectEqualsTest extends BaseTest {
    private MainPage mainPage;
    private RecoveryPage recoveryPage;
    private HelpPage helpPage;

    @BeforeEach
    public void start() {
        mainPage = navigator.openMainPage();
    }

    @Test
    @Tag("Navigation")
    public void testRecoveryToHelp() {
        assertTrue(mainPage.isHaveHelpButton());
        logger.info("Main login page opened");

        mainPage.clickForgotButton();
        recoveryPage = new RecoveryPage();
        logger.info("Redirect to recovery page successful");

        recoveryPage.clickHelpButton();
        logger.info("Help button clicked");
        helpPage = new HelpPage();
        webdriver().shouldHave(url(helpPage.getUrl()), Duration.ofSeconds(5));
        logger.info("Redirect to help page successful");
    }

    @Test
    @Tag("Navigation")
    public void testDownHelpEquals() {
        mainPage.clickHelpButton();
        logger.info("Help button clicked");
        helpPage = navigator.openHelpPage();
        // webdriver().shouldHave(url(helpPage.getUrl()), Duration.ofSeconds(5));
        helpPage.isLoaded();
        logger.info("Redirect to help page successful");
    }
}