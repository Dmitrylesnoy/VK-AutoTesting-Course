package ok.navigationTest;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.example.okmsger.pages.HelpPage;
import org.example.okmsger.pages.MainPage;
import org.example.okmsger.pages.RecoveryPage;
import org.junit.jupiter.api.*;

import ok.BaseTest;

import static com.codeborne.selenide.WebDriverConditions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelpRedirectEqualsTest extends BaseTest{
    private MainPage mainPage;
    private RecoveryPage recoveryPage;
    private HelpPage helpPage;

    @BeforeAll
    public void pages() {
        // Configuration.browser = "chrome";
        mainPage = new MainPage();
        recoveryPage = new RecoveryPage();
        helpPage = new HelpPage();

    }

    @BeforeEach
    public void openMainPage() {
        open(mainPage.getUrl());
    }

    @Test
    @Tag("Navigation")
    public void testRecoveryToHelp() {
        assertTrue(mainPage.isHaveHelpButton());
        logger.info("Main login page opened");

        mainPage.clickForgotButton();
        webdriver().shouldHave(urlContaining(recoveryPage.getUrl()));
        logger.info("Redirect to recovery page success");

        recoveryPage.clickHelpButton();
        logger.info("Help button clicked");
        webdriver().shouldHave(url(helpPage.getUrl()), Duration.ofSeconds(5));
    }

    @Test
    public void testDownHelpEquals() {
        mainPage.clickHelpButton();
        logger.info("Help button clicked");

        webdriver().shouldHave(url(helpPage.getUrl()), Duration.ofSeconds(5));
    }
}