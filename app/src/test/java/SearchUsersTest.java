import static com.codeborne.selenide.Configuration.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.okmsger.pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("search")
@DisplayName("User Search Tests")
public class SearchUsersTest {
    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        browser = "chrome";
        searchPage = new SearchPage();
    }


    @ParameterizedTest
    @ValueSource(strings = {"Иван Иванов", "Петр Петров", "Сергей Сергеев"})
    @DisplayName("Parameterized user search test")
    public void testSearchUsersWithDifferentQueries(String query) {
        searchPage.open();
        searchPage.enterSearchQuery(query);
        searchPage.clickSearchButton();

        assertTrue(searchPage.getResultsCount() > 0,
                "Search should return more than 0 results for query: " + query);
    }
}