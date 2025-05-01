package ok.navigationTest;

import org.example.okmsger.pages.HelpPage;
import org.example.okmsger.pages.MainPage;
import org.example.okmsger.pages.RecoveryPage;
import org.example.okmsger.utils.Navigator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ok.BaseTest;

public class HelpRedirectEqualsTest extends BaseTest {
    private MainPage mainPage;
    private RecoveryPage recoveryPage;

    @BeforeEach
    public void start() {
        mainPage = new MainPage();
        // mainPage.open();
    }

    @Test
    @Tag("Navigation")
    public void testRecoveryToHelp() {
        mainPage.clickForgotButton();
        recoveryPage = new RecoveryPage();
        recoveryPage.clickHelpButton();
        Navigator.checkUrl(HelpPage.getUrl());
        logger.info("Redirect to help page successful");
    }

    @Test
    @Tag("Navigation")
    public void testDownHelpEquals() {
        mainPage.clickHelpButton();
        // webdriver().shouldHave(url(helpPage.getUrl()), Duration.ofSeconds(5));
        Navigator.checkUrl(HelpPage.getUrl());
    }
}