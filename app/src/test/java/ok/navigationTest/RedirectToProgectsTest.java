package ok.navigationTest;

import static com.codeborne.selenide.Selenide.*;

import org.example.okmsger.pages.SearchPage;
import org.example.okmsger.utils.Navigator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ok.BaseTest;

public class RedirectToProgectsTest extends BaseTest {
    private SearchPage searchPage;

    @BeforeEach
    public void start() {
        searchPage = new SearchPage();
        // searchPage.open();
    }

    @Test
    @Tag("Navigation")
    @DisplayName("Test navigation to VK Projects page")
    public void shouldNavigateToVkProjects() {
        searchPage.clickFirstButton()
                .clickSecondButton();
        switchTo().window(1);
        logger.info("Switched to new window");
        String expectedUrl = "https://vk.company/ru/projects/";
        Navigator.checkUrl(expectedUrl);
        logger.info("Navigation to VK Projects page successful");
    }
}