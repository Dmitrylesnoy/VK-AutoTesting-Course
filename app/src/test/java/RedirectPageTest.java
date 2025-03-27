
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.*;

import org.example.okmsger.SearchPage;

public class RedirectPageTest {
    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        searchPage = new SearchPage();
    }

    @Test
    @DisplayName("Проверка перехода с ok.ru/search/profiles на vk.company/ru/projects")
    public void shouldNavigateToVkProjects() {
        searchPage.open()
                .acceptCookiesIfPresent() // Закрываем баннер с куки, если он есть
                .clickFirstButton() // Кликаем первую кнопку
                .clickSecondButton(); // Кликаем вторую кнопку

        // Ожидаем, пока URL обновится
        String currentUrl = searchPage.getCurrentUrl();
        String expectedUrl = "https://ok.ru/search/profiles";

        assertNotEquals(expectedUrl, currentUrl,
                "После нажатия кнопок должен произойти переход на " + expectedUrl);
    }
}