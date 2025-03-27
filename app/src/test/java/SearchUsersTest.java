import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.okmsger.SearchPage;

public class SearchUsersTest {
    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        browser = "chrome";
        searchPage = new SearchPage();
    }

    @Test
    @DisplayName("Проверка, что поиск 'Иван Иванов' возвращает больше 0 результатов")
    public void testSearchUserByName() {
        searchPage.open();
        searchPage.enterSearchQuery("Иван Иванов");
        searchPage.clickSearchButton();

        assertTrue(searchPage.getResultsCount() > 0,
                "Поиск 'Иван Иванов' должен вернуть больше 0 результатов");
    }
}