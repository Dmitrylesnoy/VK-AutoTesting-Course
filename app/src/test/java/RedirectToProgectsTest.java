
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.Selenide.webdriver;
import java.time.Duration;

import org.example.okmsger.pages.SearchPage;

@Tag("navigation")
@DisplayName("Projects Redirect Tests")
public class RedirectToProgectsTest {
    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        searchPage = new SearchPage();
    }

    @Test
    @DisplayName("Test navigation to VK Projects page")
    public void shouldNavigateToVkProjects() {
        searchPage.open()
                .clickFirstButton()
                .clickSecondButton();

        String expectedUrl = "https://vk.company/ru/projects/";

        webdriver().shouldHave(url(expectedUrl), Duration.ofSeconds(5));
        // assertEquals(expectedUrl, currentUrl,
        //         "После нажатия кнопок должен произойти переход на " + expectedUrl);
    }

    @AfterAll
    public void ShutDown() {
        
    }
}