import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;
import org.example.okmsger.pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.codeborne.selenide.Configuration;

public class SearchUsersTest {
    private static final Logger logger = Logger.getLogger(SearchUsersTest.class.getName());
    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        searchPage = new SearchPage();
    }

    @ParameterizedTest
    @Tag("Search")
    @ValueSource(strings = { "Иван Иванов", "Петр Петров", "Сергей Сергеев" })
    @DisplayName("Parameterized user search test")
    public void testSearchUsersWithDifferentQueries(String query) {
        searchPage.open();
        searchPage.enterSearchQuery(query);
        logger.info("Entered search query: " + query);
        searchPage.clickSearchButton();
        logger.info("Clicked search button");

        assertTrue(searchPage.getResultsCount() > 0,
                "Search should return more than 0 results for query: " + query);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}