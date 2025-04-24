package ok.functionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.okmsger.pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ok.BaseTest;

public class SearchUsersTest extends BaseTest {
    private SearchPage searchPage;

    @BeforeEach
    public void pages() {
        searchPage = new SearchPage();
    }

    @ParameterizedTest
    @Tag("Search")
    @ValueSource(strings = { "Иван Иванов", "Петр Петров", "Сергей Сергеев" })
    @DisplayName("Parameterized user search test")
    public void testSearchUsersWithDifferentQueries(String query) {
        searchPage.open().enterSearchQuery(query);
        super.logger.info("Entered search query: " + query);
        searchPage.clickSearchButton();
        logger.info("Clicked search button");

        assertTrue(searchPage.getResultsCount() > 0,
                "Search should return more than 0 results for query: " + query);
    }
}