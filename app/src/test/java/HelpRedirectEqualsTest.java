import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.logging.Logger;

import org.example.okmsger.pages.HelpPage;
import org.example.okmsger.pages.MainPage;
import org.example.okmsger.pages.RecoveryPage;
import org.junit.jupiter.api.*;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverConditions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelpRedirectEqualsTest {
    private static final Logger logger = Logger.getLogger(HelpRedirectEqualsTest.class.getName());
    private MainPage mainPage;
    private RecoveryPage recoveryPage;
    private HelpPage helpPage;

    @BeforeAll
    public void setUp() {
        Configuration.browser = "chrome";
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

    @AfterAll
    public void tearDown() {
        closeWebDriver();
    }
}