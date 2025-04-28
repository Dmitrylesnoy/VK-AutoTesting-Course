package ok.navigationTest;

import org.example.okmsger.pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ok.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import java.time.Duration;

public class RedirectToProgectsTest extends BaseTest {
    private SearchPage searchPage;

    @BeforeEach
    public void start() {
        searchPage = navigator.openSearchPage();
    }

    @Test
    @Tag("Navigation")
    @DisplayName("Test navigation to VK Projects page")
    public void shouldNavigateToVkProjects() {
        searchPage.clickFirstButton()
                .clickSecondButton();
        logger.info("Menu and button clicked");

        switchTo().window(1);
        logger.info("Switched to new window");
        String expectedUrl = "https://vk.company/ru/projects/";
        webdriver().shouldHave(url(expectedUrl), Duration.ofSeconds(10));
        logger.info("Navigation to VK Projects page successful");
    }
}