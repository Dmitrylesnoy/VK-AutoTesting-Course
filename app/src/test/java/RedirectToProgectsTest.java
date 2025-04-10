
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import java.time.Duration;
import java.util.logging.Logger;

import org.example.okmsger.pages.SearchPage;

public class RedirectToProgectsTest {
    private static final Logger logger = Logger.getLogger(RedirectToProgectsTest.class.getName());
    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        searchPage = new SearchPage();
    }

    @Test
    // @Disabled
    @Tag("Navigation")
    @DisplayName("Test navigation to VK Projects page")
    public void shouldNavigateToVkProjects() {
        searchPage.open()
                .clickFirstButton()
                .clickSecondButton();
        logger.info("Menu and button clicked");
        
        switchTo().window(1);
        logger.info("Switched to new window");
        String expectedUrl = "https://vk.company/ru/projects/";
        webdriver().shouldHave(url(expectedUrl), Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}