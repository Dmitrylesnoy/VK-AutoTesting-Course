package ok.functionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.okmsger.pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import ok.BaseTest;

public class SearchUsersTest extends BaseTest {
    private SearchPage searchPage;

    @BeforeEach
    public void start() {
        searchPage = new SearchPage();
    }

    @Nested
    @DisplayName("Search functionality tests")
    class SearchFunctionalityTests {

        @ParameterizedTest
        @Tag("Search")
        @ValueSource(strings = { "Иван Иванов", "Петр Петров", "Сергей Сергеев" })
        @DisplayName("Search users with button click")
        public void testSearchUsersWithButton(String query) {
            searchPage.enterSearchQuery(query);
            searchPage.clickSearchButton();
            assertTrue(searchPage.getResultsCount() > 0,
                    "Search should return more than 0 results for query: " + query);
        }

        @ParameterizedTest
        @Tag("Search")
        @CsvSource({
                "Иван Иванов, 10",
                "Петр Петров, 5",
                "Сергей Сергеев, 3"
        })
        @DisplayName("Search users with Enter and expected minimum results")
        public void testSearchUsersWithEnter(String query, int minResults) {
            searchPage.enterSearchQuery(query);
            searchPage.submitSearchWithEnter();
            assertTrue(searchPage.getResultsCount() >= minResults,
                    "Search should return at least " + minResults + " results for query: " + query);
        }
    }
}