import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.example.okmsger.pages.HelpPage;
import org.example.okmsger.pages.MainPage;
import org.example.okmsger.pages.RecoveryPage;
import org.junit.jupiter.api.*;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverConditions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelpRedirectEqualsTest {
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
    public void testRecoveryToHelp() {
        assertTrue(mainPage.isHaveHelpButton());
        System.out.println("Main login page oppened");

        mainPage.clickForgotButton();
        webdriver().shouldHave(urlContaining(recoveryPage.getUrl()));
        System.out.println("Redirect to recovery page succes");

        recoveryPage.clickHelpButton();
        System.out.println("Help button clicked");
        webdriver().shouldHave(url(helpPage.getUrl()), Duration.ofSeconds(5));
    }

    @Test
    public void testDownHelpEquals() {
        mainPage.clickHelpButton();
        System.out.println("Help button clicked");

        webdriver().shouldHave(url(helpPage.getUrl()), Duration.ofSeconds(5));
    }

    @AfterAll
    public void tearDown() {
        closeWebDriver();
    }
}