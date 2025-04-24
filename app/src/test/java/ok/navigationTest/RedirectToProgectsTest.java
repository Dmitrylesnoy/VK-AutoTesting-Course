package ok.navigationTest;

import ok.BaseTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import java.time.Duration;
import org.example.okmsger.pages.SearchPage;

public class RedirectToProgectsTest extends BaseTest{
    private SearchPage searchPage;

    @BeforeEach
    public void pages() {
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
}